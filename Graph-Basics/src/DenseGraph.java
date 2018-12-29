import java.util.Vector;

/**
 * 稠密图的实现 -- 邻接矩阵
 *
 * @author DUSTY
 */
public class DenseGraph {

    /**
     * 点数
     */
    private int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        //初始化没有任何边
        this.m = 0;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    /**
     * 查询节点个数
     *
     * @return
     */
    public int V() {
        return n;
    }

    /**
     * 查询有多少边
     *
     * @return
     */
    public int E() {
        return m;
    }

    /**
     * 向图中添加一条边
     *
     * @param v 图中一点
     * @param w 图中一点
     */
    public void addEdge(int v, int w) {

        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;

        //是否是有向图
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    /**
     * 判断给定的两点之间是否已存在边
     * 时间复杂度：O(1)
     * @param v
     * @param w
     * @return boolean
     */
    private boolean hasEdge(int v, int w) {
        return g[v][w];
    }

    /**
     * 返回图中一个顶点的所有邻边
     *
     * @param v 考察的元素
     * @return
     */
    public Iterable<Integer> adj(int v) {
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

}
