package dusty.algo;

/**
 * @author DUSTY
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            //寻找元素arr[]合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    /**
     * 交换两个元素的位置
     * @param arr 待排序序列
     * @param j
     * @param i
     */
    private static void swap(Object[] arr, int j, int i) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 测试InsertionSort
     * @param args
     */
    public static void main(String[] args){

        int N = 20000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("dusty.algo.InsertionSort",array);
    }
}
