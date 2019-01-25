import java.util.Random;

/**
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(10));
        }

        int[] arr = new int[n];
        //用数组来存放最大堆
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        //验证是否最大堆（extractMax的正确性）
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("error");
            } else {
                System.out.println("correct！");
            }
        }
    }
}
