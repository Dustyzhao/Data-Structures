package dusty.algo;

import java.util.Arrays;

/**
 * 自底向上的实现归并排序
 * Merge Sort BU 也是一个O(nlogn)复杂度的算法
 * 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
 * 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
 * @author DUSTY
 */
public class MergeSortBU {

    /**
     * 归并排序元素分类的实现
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        /**
         *外层循环是对进行merge的元素个数（每次有几个元素进行归并操作）进行遍历
         *我们这里是两两归并所以外层步进是size*=2，起始是单个元素进行归并，所以size初始化为1，而非0.
         *
         *内存循环是每轮归并过程中元素的始末位置，i是起始位置，而每轮当前遍历的步进为（外层控制的）size *= 2，
         *所以内层的步进应该为i += size + size.考虑到边界问题，应该设置循环停止条件为i + size < arr.length（这样保证了后半部元素得以正常参与归并），而非i < arr.length。
         *
         *同样考虑到边界问题，在进行内层merge操作时，i + size + size可能存在会比arr.length大的情况，此时我们直接取二者间较小值即可。
         *
         */
        for (int size = 1; size < arr.length; size *= 2) {

            for (int i = 0; i + size < arr.length; i += size + size) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr,i,i + size -1,Math.min(i + size + size -1,arr.length - 1));
            }
        }

        //同正常归并算法一样，一样可以对自底向上这中做出两处的优化.注释参考前边的递归算法实现
        int t = 16;
        for (int i = 0; i < arr.length; i += t) {
            InsertionSort.sort(arr,i,Math.min(i + t - 1,t - 1));
        }
        for (int size = t; size < arr.length; size *= 2) {
            for (int i = 0; i + size < arr.length; i += size + size) {
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
                }
            }
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
     * 测试MergeSort
     * @param args
     */
    public static void main(String[] args){

        int N = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("dusty.algo.MergeSortBU",array);
    }

}
