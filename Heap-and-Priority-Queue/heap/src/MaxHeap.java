/**
 * 最大堆MaxHeap的实现
 * 支持泛型E，节点之间具有可比性→继承Comparable
 * 用我们自己实现的可变容量Array来存储二叉堆,索引从0开始
 *
 * @author DUSTY
 */
public class MaxHeap<E extends Comparable<E>> {

    protected Array<E> data;

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
     * heapify:把任意数组整理成堆的形状
     *
     * @param arr 待整理的数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
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
     *
     * @param i 插入元素在数组中表示的索引
     */
    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * 从（最大）堆中取出最大值
     *
     * @return 堆的最大值
     */
    public E extractMax() {
        E max = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return max;
    }

    /**
     * “新根节点“的siftDown，维系最大堆的性质
     *
     * @param i “新根节点“的索引值
     */
    private void siftDown(int i) {
        //i没有子节点时停止循环
        while (leftChild(i) <= data.getSize() - 1) {
            int j = leftChild(i);
            //比较其两个子节点的大小
            if (j < data.getSize() - 1 && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //保证j永远代表较大的子节点的索引值
                j++;
            }
            //比较”新根节点“与较大子节点的大小
            if (data.get(j).compareTo(data.get(i)) <= 0) {
                break;
            }
            data.swap(i, j);
            //维系i
            i = j;
        }
    }

    /**
     * 查看堆中最大元素
     * 用户也会使用，修改成public
     *
     * @return 堆中最大元素，即根节点
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆是空的");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E max = findMax();

        data.set(0, e);
        siftDown(0);

        return max;
    }

}
