package dusty.algo;

/**
 * 图的接口
 *
 * @author DUSTY
 */
public interface Graph {

    /**
     * 获取图的节点数
     *
     * @return 节点数
     */
    public int V();

    /**
     * 获取图的边数
     *
     * @return 边数
     */
    public int E();

    /**
     * 为图添加一条边
     *
     * @param v 指定节点
     * @param w 指定节点
     */
    public void addEdge(int v, int w);

    /**
     * 判断给定的两点有无边
     *
     * @param v 指定节点
     * @param w 指定节点
     * @return boolean
     */
    public boolean hasEdge(int v, int w);

    /**
     * 遍历图中某一节点的所有边
     *
     * @param v 指定节点
     * @return 边
     */
    public Iterable<Integer> adj(int v);

    /**
     * 显示图的信息
     */
    void show();
}
