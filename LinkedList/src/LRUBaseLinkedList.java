import java.util.Scanner;

/**
 * 基于单链表实现LRU
 *
 * @author DUSTY
 */
public class LRUBaseLinkedList<T> {

    /**
     * 链表的初始容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 虚拟头结点
     */
    private Node<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new Node<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;

    }

    /**
     * 添加一个元素
     * @param data
     */
    public void add(T data) {
        Node preNode = findPreNode(data);

        //链表中已存在，则删除该数据，重新插入到链表头部
        if (preNode != null) {
            deleteElement(preNode);
            insertElementIntotheBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElementFromtheEnd();
            } else {
                //插入到头部
                insertElementIntotheBegin(data);
            }
        }
    }

    /**
     * 删除尾结点
     */
    private void deleteElementFromtheEnd() {
        Node<T> node = this.headNode;
        //空链表直接返回
        if (node.getNext() == null) {
            return;
        }

        //查找倒数第二个结点
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        length--;
    }

    /**
     * 插入元素到头部
     *
     * @param data
     */
    private void insertElementIntotheBegin(T data) {
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }

    /**
     * 删除preNode的下一个结点
     *
     * @param preNode
     */
    private void deleteElement(Node preNode) {
        Node forDel = preNode.getNext();
        preNode.setNext(forDel.getNext());
        forDel.setNext(null);
        length--;

    }

    /**
     * 获取链表中与待查找元素相同的结点的前一个结点
     *
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        Node node = headNode;
        while (node.getNext() != null) {
            //如果找到了
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            //接着看下一结点
            node = node.getNext();
        }
        return null;
    }

    public void printAll() {
        Node next = headNode.getNext();
        while (next != null) {
            System.out.println(next.getElement() + ",");
            next=next.getNext();
        }
        System.out.println();
    }



    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(T element) {
            this.element = element;
        }

        public Node() {
            this(null, null);
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args){
        //测试LRUBaseLinkedList
        LRUBaseLinkedList lruBaseLinkedList = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            lruBaseLinkedList.add(scanner.nextInt());
            lruBaseLinkedList.printAll();
        }
    }
}