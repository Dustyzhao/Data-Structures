package dusty.algo;

/**
 * 最基础的选择排序
 * @author DUSTY
 */
public class SelectionSort {

    public static void sort(int[] arr) {

        for (int i = 0;i < arr.length - 1 ; i ++){
            // 寻找[i, n)区间里的最小值的索引
            // 假设当前索引对应的是最小值
            int minIndex = i;
            //依次与其后的值进行大小对比，如果比当前值arr[i]小，则交换位置。
            for (int j = i + 1;j < arr.length;j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }

    }

    /**
     * 交换位置方法实现：两个数字按从小到大的顺序排列起来
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
            System.out.print(' ');
        }

    }
}
