/**
 * 最大堆MaxHeap的实现
 * 支持泛型E，节点之间具有可比性→继承Comparable
 * 用我们自己实现的可变容量Array来存储二叉堆,索引从0开始
 *
 * @author DUSTY
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    /**
     * 用户知道MaxHeap容量时，可直接创建指定容量的数组
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 查寻最大堆的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 查找指定位置元素的父亲节点
     *
     * @param index 指定位置元素在数组中的索引
     * @return 指定位置元素的父亲节点在数组中的索引
     */
    private int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("‘0’位置的索引没有父亲节点");
        }
        return (index - 1) / 2;
    }

    /**
     * 查找指定位置元素的左孩子节点
     *
     * @param index 指定位置元素在数组中的索引
     * @return 指定位置元素的左孩子节点在数组中的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 查找指定位置元素的右孩子节点
     *
     * @param index 指定位置元素在数组中的索引
     * @return 指定位置元素的右孩子节点在数组中的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e 待添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 插入元素siftup“上浮”操作：维护最大堆的性质
     * @param i 插入元素在数组中表示的索引
     */
    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i,parent(i));
            i = parent(i);
        }
    }


}
