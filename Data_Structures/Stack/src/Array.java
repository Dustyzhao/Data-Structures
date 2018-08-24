/**
 * @author DUSTY
 */
public class Array<E> {
    /**
     *为保证数据安全，我们封装字段，以免被无端修改，导致
     * 数据前后不一致的情况出现
     */
    private E[] data;
    private int size;

    /**
     * 传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造，默认数组容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return size大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return size是否为空
     */
    public boolean isEmpty() {
        //判断size是否等于0
        return size == 0;
    }

    /**
     * 向数组末尾中添加一个新元素
     * @param e 想要插入的元素
     */
    public void addLast(E e){
//        //先判断数组是否已满
//        if (data.length == size){
//            throw new IllegalArgumentException("AddLast failed,Array is full.")
//        }
//        //执行插入操作，并将size指向数组内部的首个空值位
//        data[size] = e;
//        size++;
        add(size,e);
    }

    /**
     * 向数组开头中添加一个新元素
     * @param e：将要插入的元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 1.在第index的位置插入一个新元素e
     * 2.主动扩容
     * @param index
     * @param e
     */
    public void add(int index,E e){

        //判断index的合法性
        if (index <0 || index >size){
            throw new IllegalArgumentException("Add failed,Require index >=0 and index <=size.");
        }

        //判断数组是否已满,已满的情况下进行扩容操作
        if (data.length == size){
            //我们不知需要具体扩多少；但2倍是合理的（容量/复杂度）；Java官方扩容是1.5.
            resize(2 * data.length);
        }

        //进行从数组尾部开始的依次地移位操作
        for (int i = size-1; i >=index ; i --) {
            data[i+1] = data[i];
        }
        //在指定位置index插入指定的元素e，并依旧将size指向数组内部的首个空值位
        data[index] = e;
        size++;
    }

    /**
     * 动态数组的实现
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        //先声明一个新数组newData
        E[] newData = (E[]) new Object[newCapacity];
        //遍历取出data[]的元素放到新数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //并将data[]指向新数组。
        data = newData;
    }

    /**
     * 获取index索引位上的元素
     * @param index
     * @return
     */
    E get(int index){
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取动态数组的最后一个元素
     * @return E e
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取动态数组的第一个元素
     * @return data[0]
     */
    public E getFirst(){
        return get(0);
    }
    /**
     * 修改index位置上的元素为e
     * @param index
     * @param e
     */
    void set(int index,E e){
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Set failed,Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e：要查找的元素
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e：要查找的元素
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 1.从数组中删除index位置上的元素，返回所删除的元素
     * 2.主动缩容
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 ||index >= size){
            throw new IllegalArgumentException("Remove failed,Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //优化，非必需；添加新元素，则该类对象自动被GC回收。
        data[size] = null;

        //动态缩容的实现：剩余容量小于原始容量的1/4时，进行缩容,
        // 避免了复杂度震荡（1/2缩容标准会有这样的问题）
        //同时当data.length = 1，禁止缩容。
        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 删除数组中的第一个元素，并返回
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素，并返回
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * delate element e from data
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
