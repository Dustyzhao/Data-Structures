package dusty.algo;

import java.util.Arrays;

/**
 * Merge Sort是一个O(nlogn)复杂度的算法
 * 可以在1秒之内轻松处理100万数量级的数据
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
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //向上归并的过程
        merge(arr,l,mid,r);
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

        //初始化，i指向左半部分的起始索引位置，j指向右半部分起始索引位置mid+1
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

        int N = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("dusty.algo.MergeSort",array);
    }
}
