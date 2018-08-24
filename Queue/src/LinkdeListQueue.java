public class LinkdeListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkdeListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        //只要队列有元素，tail和head就不会为null
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        //改变head retNode的指向
        head = head.next;
        retNode.next = null;
        //如果队列中只有一个元素
        if (head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur!=null){
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL tail");
        return res.toString();
    }

    /**
     * test 每入队三个元素，出队一个
     * @param args
     */
    public static void main(String[] args){
        LinkdeListQueue<Integer> queue = new LinkdeListQueue<>();
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
