package dusty.algo;

import java.io.FileNotFoundException;

/**
 * 测试用例:
 * 从文件testG1.txt和testG2.txt中读取出两种图的形式
 *
 * @author DUSTY
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "D:\\myrepository\\Graph-Basics\\src\\testG2.txt";
        DenseGraph denseGraph = new DenseGraph(6, false);
        ReadGraph readGraph = new ReadGraph(denseGraph, fileName);
        System.out.println("testG1.txt in denseGraph:");
        denseGraph.show();
        System.out.println();

        SparseGraph sparseGraph = new SparseGraph(6, false);
        ReadGraph readGraph1 = new ReadGraph(sparseGraph, fileName);
        System.out.println("testG1.txt in sparseGraph:");
        sparseGraph.show();
    }



}
