public class LoopQueue<E> implements Queue<E> {
     //与动态数组差距很大，底层不再复用动态数组

    private E[] data;
    private int front,tail;
    //todo 不定义size，怎么写这个逻辑？
    private int size;

    public LoopQueue(int capacity){
        //因为循环队列本身是要消耗一个单位的，为了容纳下capacity个单位，
        //需要我们声明一个capacity+1个单位
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        //调用带参构造方法
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        //判断队列是否已满
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        //因为是在循环队列中，tail++不可行
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        //暂存队首元素，因为需要返回
        E ret = data[front];
        //出队后，队首元素为空
        data[front] = null;
        //调整front指向（位置），因在循环队列，不能进行front++操作
        front = (front + 1) % data.length;
        size--;
        //缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    /**
     * 数组扩容实现
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //newData[0]对应data[front];newData[1]对应data[front + 1]...
            //需要数组循环起来，并且i + front存在数组越界问题，故取余
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n",size,getCapacity()));
        res.append("front [");
        //todo 类似于上面的resize中的for循环来实现一遍以下的循环操作
        for (int i = front; i != tail ; i = (i+1)%data.length) {
            res.append(data[i]);
            //当前元素是否等于tail，
            if ((i+1)%data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
