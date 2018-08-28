
/**
 * @author DUSTY
 * implements Set based on BST
 * BSTSet必须是可以比较的，所以要实现comparable接口
 * 我们的BST本身就是不允许添加重复元素的，所以可以无缝实现Set接口中所有的方法
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 用户不可见，私有
     */
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

}
