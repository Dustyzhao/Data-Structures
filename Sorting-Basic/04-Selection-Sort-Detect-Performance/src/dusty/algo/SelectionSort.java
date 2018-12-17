package dusty.algo;

/**
 * 使用Comparable接口实现的选择排序
 * @author DUSTY
 */
public class SelectionSort {

    public static void sort(Comparable[] arr) {

        for (int i = 0;i < arr.length - 1 ; i ++){
            // 寻找[i, n)区间里的最小值的索引
            // 假设当前索引对应的是最小值
            int minIndex = i;
            //依次与其后的值进行大小对比，如果比当前值arr[i]小，则交换位置，从而找到本次循环的最小值
            for (int j = i+1 ;j < arr.length;j ++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }

    }

    /**
     * 交换位置方法实现：两个数字按从小到大的顺序排列起来
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);

        SortTestHelper.testSort("dusty.algo.SelectionSort",arr);
    }
}
