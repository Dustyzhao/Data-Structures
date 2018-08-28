
/**
 *基于链表实现集合
 *链表本身不要求其元素的可比性，so不用实现comparable接口
 * @author DUSTY
 */
public class LinkedListSet<E> implements Set<E> {

    /**
     *基于链表实现嘛，所以要求有链表对象
     */
    private LinkedList<E> list;

    public LinkedListSet(){
        list= new LinkedList<>();
    }


    /**
     * 稍有不同：不能往集合中添加相同元素，所以需要我们先判断
     * @param e
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
