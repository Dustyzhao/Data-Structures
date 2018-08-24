public class LinkedList<E> {

    /**
     * 私有化内部类，只有外部类LinkedList可直接访问，
     * 用户不可见，对用户隐藏其底层实现细节，
     */
    private class Node{

        /**
         * 这里把内部类的成员属性设计成public，对外部类LinkedList可直接访问
         * 省去对其的get，set方法
         * e：存放的元素
         */
        public E e;
        /** next：指向Node的引用 */
        public Node next;

        /**
         * 用户传来e和next的情况，直接调用该方法
         * @param e
         * @param next
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 用户只传来e的情况
         * @param e
         */
        public Node(E e) {
            this(e,null);
        }

        /**
         * 用户什么都不传
         */
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    /**
     *链表中应该有个Node型变量head，为外部不可见private
     */
    private Node dummyHead;
    /**
     * 链表长度size，为外部不可见private
     */
    private int size;

    public LinkedList() {
        //初始化时既有一个节点：虚拟头节点
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表的index（0-based）位置添加新的元素
     * 在链表中不是一个常用的操作，练习用。
     * @param index
     * @param e
     */
    public void add(int index,E e){

        //判断index的合法性
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }
            //创建prev节点（或标志）
            Node prev = dummyHead;
            //移动prev到index前一位置
            for (int i = 0; i < index ; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
//              上面三行更优雅的实现
            prev.next = new Node(e,prev.next);
            size ++;
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
//         Node node = new Node(e);
//         node.next = head;
//         head = node;
        add(0,e);
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index（0-based）个位置的元素
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @return
     */
    public E get(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }


    /**
     * 修改链表的第index（0-based）个位置的元素为e
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @param e
     */
    public void set(int index , E e){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed,illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    /**
     * 查找链表中是否含有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 从链表中删除index（0-based）位置的元素，返回删除的元素
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failde,Index is illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    /**
     * 在链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 在链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next;cur != null; cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
