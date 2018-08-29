import java.util.ArrayList;

/**
 * 基于BST实现的Map
 * BST的K要能比较大小
 * @author DUSTY
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点root
     */
    private Node root;
    /**
     * size：元素个数
     */
    private int size;

    public BSTMap(){
        root = null;
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
     * 向二分搜索树中添加新的元素（key，value）
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素（key，value），递归算法
     * 返回插入新节点后的二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null){
            size++;
            return new Node(key,value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else {
            //此时，key.compareTo(node.key) == 0
            //我们认为用户是想更新value，也可以有其他逻辑。
            node.value = value;
        }
        return node;
    }

    /**
     * 辅助函数
     * 返回以node为根节点的二分搜索树中，key所在的节点
      * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) == 0){
            return node;
        }else if (key.compareTo(node.key) < 0 ){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }

    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(root,key) == null ? null:getNode(root,key).value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null){
            throw new  IllegalArgumentException(key+"doesn't exist!");
        }
        node.value = newValue;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为（key，value）的节点
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            //真正的删除过程
            root = remove(root ,key);
            return node.value;
        }
        return null;
    }

    /**
     * 删除掉以node为根的二分搜索树中键为key的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else {
            //待删除的节点左子树为空时
            if (node.left ==null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除的节点右子树为空时
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
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
            BSTMap<String,Integer> map = new BSTMap<>();
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
