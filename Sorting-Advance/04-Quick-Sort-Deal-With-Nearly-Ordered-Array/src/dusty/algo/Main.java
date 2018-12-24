package dusty.algo;

import java.util.Arrays;

/**
 * 比较MergeSort和QuickSort两种排序算法的性能效率
 *
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int N = 20000;

        //测试1，一般测试
        System.out.println("测试两种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ N +"]");

        Integer[] array1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.MergeSort", array1);
        SortTestHelper.testSort("dusty.algo.QuickSort", array2);
        SortTestHelper.printArray(array2);

        /**
         * 测试2，测试对近乎有序数组的排序效率
         * 对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
         * 经过尝试, 当swapTimes比较大时, MergeSort更快
         * 但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快
         */

        int swapTime = 50;
        System.out.println("测试两种算法对近乎有序数组的排序性能，数组的长度为：" + N + " , swap time =" + swapTime);

        Integer[] array4 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        Integer[] array5 = Arrays.copyOf(array4, array4.length);

        SortTestHelper.testSort("dusty.algo.MergeSort", array4);
        SortTestHelper.testSort("dusty.algo.QuickSort", array5);

    }
}
