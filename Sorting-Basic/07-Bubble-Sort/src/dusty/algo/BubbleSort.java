package dusty.algo;

/**
 * @author DUSTY
 */
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            //添加标志位，来判断是否进行了交换
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            //一次排序中未发生交换行为，则说明序列已经有序，排序结束
            if (flag == false) {
                break;
            }
        }
    }
    //优化之前的冒泡排序
//    public static void sort(Comparable[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//
//                if (arr[j].compareTo(arr[j + 1]) > 0) {
//                    swap(arr,j,j+1);
//                }
//            }
//        }
//    }

    private static void swap(Object[] arr, int j, int i) {
        Object t = arr[j+1];
        arr[j+1] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        Integer[] arr = {7,0,-1,-1,-2,3,6,5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
