package dusty.algo;

import java.util.Arrays;

/**
 * Merge Sort是一个O(nlogn)复杂度的算法
 * 可以在1秒之内轻松处理100万数量级的数据
 * 经过两处的优化，归并排序的时间复杂度仍旧是O（nlogn）
 * @author DUSTY
 */
public class MergeSort {

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序
     * @param arr 被排序的数组
     * @param l 数组第一个元素
     * @param r 数组最后一个元素
     */
    private static void sort(Comparable[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        // 优化2: 对于小规模数组, 使用插入排序,对上面的语句优化为：这里的n(规模)可调整
        int n = 15;
        if( r - l <= n ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //向上归并的过程
//        merge(arr,l,mid,r);
        // 优化1：对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失。上面的语句可优化为：
        if (arr[mid].compareTo(arr[mid+1]) > 0 ) {
            merge(arr,l,mid,r);
        }
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     * @param arr 被排序的数组
     * @param l 数组第一个元素
     * @param mid (l + r) / 2
     * @param r 数组最后一个元素
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        /**
         * 定义一个辅助函数来帮助我们更便捷地实现归并排序
         * copyOfRange是左闭右开，所以是r+1，而不是r。
         */
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        /**
         * 定义i、j、k用来跟踪数组排序进度，i、j为当前进行比较的元素，k为已排序序列的下一位置
         * 初始化时，i指向左半部分的起始索引位置，j指向右半部分起始索引位置mid+1，k为待排序序列起始位置
         *
         */
        int i = l,j = mid+1;
        for (int k = l; k <= r; k++) {
            //考虑到“越界”问题
            if (i > mid) {
                //此时左半部分元素已全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //此时右半部分元素已全部处理完毕
                arr[k] = aux[i - l];
                i++;
            }

            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                //左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            }else {
                //左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    /**
     * 外部调用使用
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

    /**
     * 测试MergeSort
     * @param args
     */
    public static void main(String[] args){

        int N = 10;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.printArray(array);
        SortTestHelper.testSort("dusty.algo.MergeSort",array);
        SortTestHelper.printArray(array);
    }
}
