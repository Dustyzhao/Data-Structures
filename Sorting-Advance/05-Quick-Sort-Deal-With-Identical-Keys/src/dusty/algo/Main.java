package dusty.algo;

import java.util.Arrays;

/**
 * 比较MergeSort和两种QuickSort排序算法的性能效率
 * 综合来看，双路快排效率最高
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int N = 1000000;

        //测试1，对于随机数组，快速排序跟双路快排效率更高
        System.out.println("测试两种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ N +"]");

        Integer[] array1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);
        Integer[] array3 = Arrays.copyOf(array1, array1.length);

//        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.MergeSort", array1);
        SortTestHelper.testSort("dusty.algo.QuickSort", array2);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array3);
//        SortTestHelper.printArray(array2);

        // 测试2，对于随机数组且包含大量重复元素，双路快排效率最高
        System.out.println("测试两种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ 10 +"]");

        Integer[] array7 = SortTestHelper.generateRandomArray(N,0,10);
        Integer[] array8 = Arrays.copyOf(array7, array7.length);
        Integer[] array9 = Arrays.copyOf(array7, array7.length);

//        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.MergeSort", array7);
//        SortTestHelper.testSort("dusty.algo.QuickSort", array8);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array9);
//        SortTestHelper.printArray(array2);

        /**
         * 测试3，测试对近乎有序数组的排序效率
         * 对于近乎有序的数组, 三种算法都很快
         */

        int swapTime = 100;
        System.out.println("测试两种算法对近乎有序数组的排序性能，数组的长度为：" + N + " , swap time =" + swapTime);

        Integer[] array4 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        Integer[] array5 = Arrays.copyOf(array4, array4.length);
        Integer[] array6 = Arrays.copyOf(array4, array4.length);

        SortTestHelper.testSort("dusty.algo.MergeSort", array4);
        SortTestHelper.testSort("dusty.algo.QuickSort", array5);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array6);
//        SortTestHelper.printArray(array5);

    }
}
