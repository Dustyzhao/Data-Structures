/**
 * @author DUSTY
 */
public interface Queue<E> {

    /**
     *查看队列大小
     * @return
     */
    int getSize();

    /**
     * 查看队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队：向队列中添加元素
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队：向队列中删除元素
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return
     */
    E getFront();
}
