import java.util.ArrayList;

/**
 * 基于LinkdeList实现的LinkedListMap，同样是支持泛型的
 * 由于支持的泛型是<K,V>，而我们以前实现的LinkedList是支持<E>,所以不能复用，需要重新写
 * @author DUSTY
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    public class Node{
        /**
         * 基于链表，不难想到下面的字段
         */
        public K key;
        public V value;
        public Node next;

        /**
         * 用户传来key，value
         * @param key
         * @param value
         * @param next
         */
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 用户只传来key
         * @param key
         */
        public Node(K key){
            this(key,null,null);

        }

        /**
         * 用户什么都不传入
         */
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        //dummyHead为空就好，用户根本不会感知其存在
        dummyHead = new Node();
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

    /**
     * 辅助函数
     *
     * @param key
     * @return key所对应的节点的引用
     */
    private Node getNode(K key){

        Node cur = dummyHead.next;
        while (cur!= null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).value;
    }

    @Override
    public void add(K key, V value) {
        //映射中不允许存在key相同的情况，所以要看先看下
        Node node = getNode(key);
        if (node == null){
            //映射中不存在要存入的key，我们在链表头添加就ok
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else{
            //映射中已经存在与将存入键相同的key
            //我们的处理：理解为新传入的kv为用户最想保存/最新的数据
            node.value = value;
        }
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException(key+"dosen't exist!");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key) {

        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }

        //真正的删除操作
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    /**
     * 测试类：词频统计、字数统计
     * @param args
     */
    public static void main(String[] args){
        System.out.println("The Shawshank Redemption");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("The Shawshank Redemption.txt",words)){
            System.out.println("Total words:"+words.size());

            //遍历words，进行词频统计。key：单词，value：频率值。
            LinkedListMap<String,Integer> map = new LinkedListMap<>();
            for (String word:words){
                if (map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            }

            System.out.println("Total different words:" + map.getSize());
            System.out.println("The Shawshank Redemption:" + map.get("shawshank"));
            System.out.println("The Shawshank Redemption:" + map.get("redemption"));
        }


    }



}
