/**
 * 基于数组的栈相关实现
 * @author DUSTY
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 声明数组
     */
    Array<E> array;

    /**
     * 已知栈容量的构造方法
     * @param capacity
     */
    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    /**
     * 未知栈容量的构造方法
     */
    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
