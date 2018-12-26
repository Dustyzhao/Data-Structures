import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author DUSTY
 */
public class BST<E extends Comparable<E>> {

    /**
     * BST的内部节点类，没必要对用户可见，故为私有
     */
    private class Node {
        /**
         * 这个节点类需要可以存储数据
         */
        public E e;
        /**
         * 具有两个节点
         */
        public Node left, right;

        /**
         * 用户传入数据，初始化该节点类
         *
         * @param e
         */
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * BST的根节点
     */
    private Node root;
    /**
     * 存储元素的个数
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e，用户调用
     *
     * @param e
     */
    public void add(E e) {

        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根，以挂接组成二分搜索树
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        /**
         * 带插入元素e与当前节点的元素node.e进行大小比较
         */
        if (e.compareTo(node.e) < 0) {
            //节点的变化需要变量承接
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 用户调用
     * 看二分搜索树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {

        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            //进入左子节点进行比较，递归
            return contains(node.left, e);
        } else {
            //进入右子节点进行比较，递归
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     * 用户调用
     */
    public void preOrder() {
        //私有过程来真正地递归实现二分搜索树地前序遍历
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的非递归前序遍历，利用栈来实现
     */
    public void preOrderNR() {
        //泛型存入Node型
        Stack<Node> stack = new Stack<>();
        //先把根节点入栈
        stack.push(root);
        //访问子节点
        while (!stack.isEmpty()) {
            //当前访问节点出栈
            Node cur = stack.pop();
            System.out.println(cur.e);
            //先入栈右孩子，接着左孩子
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 用户调用
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 用户调用
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {

        //Queue是个接口，需要选取其底层的具体实现方式
        Queue<Node> queue = new LinkedList<>();
        //根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            //当前节点出队
            Node cur = queue.remove();
            System.out.println(cur.e);
            //依次访问当前节点的左孩子、右孩子
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public E minmum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minmum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minmum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minmum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {

        if (node.right == null) {
            return node;
        }
        return minmum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，并返回最小值
     *
     * @return
     */
    public E removeMin() {
        //先获取最小值
        E ret = minmum();
        //进行删除操作,记得删除后重新付给root
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后的新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        //先写递归终止条件：再没有左孩子
        if (node.left == null) {
            //暂存当前节点的右子树
            Node rightNode = node.right;
            //将当前节点与二分搜索树脱离关系
            node.right = null;
            size--;
            return rightNode;
        }

        //承接删除后的结果，改变二分搜索树的结构
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在的节点，并返回最小值
     *
     * @return
     */
    public E removeMax() {
        //先获取最小值
        E ret = maximum();
        //进行删除操作,记得删除后重新付给root
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后的新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        //先写递归终止条件：再没有右孩子
        if (node.right == null) {
            //暂存当前节点的左子树
            Node leftNode = node.left;
            //将当前节点与二分搜索树脱离关系
            node.left = null;
            size--;
            return leftNode;
        }

        //承接删除后的结果，改变二分搜索树的结构
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点，不需要返回值
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//e == node.e
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空
            //找到比待删除节点大的最小值，即待删除节点右子树的最小节点
            //用这个节点代替待删除节点的位置
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;

        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node  根节点
     * @param depth 二叉树的深度
     * @param res   描述字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
