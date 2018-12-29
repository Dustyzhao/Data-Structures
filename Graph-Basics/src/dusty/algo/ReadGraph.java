package dusty.algo;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * 从文件中读取图
 * 通用模板，不区分稠密图还是稀疏图
 *
 * @author DUSTY
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String fileName) {

        readFile(fileName);

        //读取节点
        int v = scanner.nextInt();
        if (v < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        }

        //读取边数（这里也可成为文本的行数）
        int e = scanner.nextInt();
        if (e < 0) {
            throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
        }

        for (int i = 0; i < e; i++) {
            //读取文件中每行的第一个节点
            int v1 = scanner.nextInt();
            //读取文件中每行的第二个节点
            int w = scanner.nextInt();
            graph.addEdge(v1, w);
        }

    }

    /**
     * 文件读取
     *
     * @param fileName
     */
    private void readFile(String fileName) {
        assert fileName!=null;

        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), "utf-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("文件不存在");
        }
    }


}
