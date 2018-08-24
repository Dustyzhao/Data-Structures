import java.util.Random;

/**
 * 简单测试下ArrayQueue和LoopQueue的复杂度具体差异
 * 严谨些的做法应该是多次测量取平均值。
 * @author DUSTY
 */
public class Main {

    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
     * @param q 鉴于Java多态性，传入Queue<>,我们可方便地使用ArrayQueue和LoopQueue
     * @param opCount 测量的数据量大小
     * @return 秒
     */
    private static double testQueue(Queue<Integer> q,int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        //入队
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        //出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int opCount = 100000;

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue,time:" + time1 +"s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time2 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time:" + time2 +"s");
    }

}
