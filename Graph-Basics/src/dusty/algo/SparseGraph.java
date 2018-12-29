package dusty.algo;

import java.util.Vector;

/**
 * 稀疏图的实现 --邻接表
 *
 * @author DUSTY
 */
public class SparseGraph implements Graph{

    /**
     * 图的点
     */
    private int n;

    /**
     * 图中的边
     */
    private int m;

    /**
     * 是否有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     * 这里使用的是向量实现，比较方便；
     * 也可以使用链表实现，好处是删除节点的时候更方便；
     */
    private Vector<Integer>[] g;

    /**
     * 根据传入的节点数，是否有向图来创建构造函数
     *
     * @param n        节点数
     * @param directed 是否有向图
     */
    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
    }

    /**
     * 查询节点个数
     *
     * @return
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 查询有多少边
     *
     * @return
     */
    @Override
    public int E() {
        return m;
    }

    /**
     * 向图中添加一条边
     * 考虑到hasEdge()的最坏时间复杂度，我们不考虑每次添加边前都去考察两点间是否已存在边
     * 即不考虑平行边的问题：允许平行边的存在。
     *
     * @param v 节点
     * @param w 节点
     */
    @Override
    public void addEdge(int v, int w) {

        //搭建v和w之间的关系：以v开头的vector，v→w
        g[v].add(w);
        //如果是无向图并且不是自环边，则需要添加上 以w开头的：w→v
        if (v != w && !directed) {
            g[w].add(v);
            m++;
        }
    }

    /**
     * 判断给定的两点之间是否已存在边
     * 最坏情况下：时间复杂度O(n)
     *
     * @param v 给定的一点
     * @param w 给定的一点
     * @return boolean
     */
    @Override
    public boolean hasEdge(int v, int w) {
        //遍历以v开头的vector，若其中存在w，返回true
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回图中一个顶点的所有邻边
     *
     * @param v 考察的节点
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        return g[v];
    }

    @Override
    public void show() {

        for (int i = 0; i < n; i++) {
            System.out.print("节点："+i+":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].elementAt(j)+"\t");
            }
            System.out.println();
        }
    }
}
