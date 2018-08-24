/**
 * @author DUSTY
 */
public interface Stack<E> {

    /**
     * 获取栈大小
     * @return size
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 向栈中添加元素
     * @param e
     */
    void push(E e);

    /**
     * 从栈中取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

}
