package dusty.algo;

import java.util.Arrays;

/**
 *比较SelectionSort, InsertionSort和BubbleSort三种排序算法的性能效率
 *
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int N = 20000;

        //测试1，一般测试
        System.out.println("测试三种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ N +"]");

        Integer[] array1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);
        Integer[] array3 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort("dusty.algo.SelectionSort", array1);
        SortTestHelper.testSort("dusty.algo.InsertionSort", array2);
        SortTestHelper.testSort("dusty.algo.BubbleSort",array3);

        //测试2，测试对近乎有序数组的排序效率
        int swapTime = 100;
        System.out.println("测试三种算法对近乎有序数组的排序性能，数组的长度为：" + N + " , swap time =" + swapTime);

        Integer[] array4 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        Integer[] array5 = Arrays.copyOf(array4, array4.length);
        Integer[] array6 = Arrays.copyOf(array4, array4.length);

        SortTestHelper.testSort("dusty.algo.SelectionSort", array4);
        SortTestHelper.testSort("dusty.algo.InsertionSort", array5);
        SortTestHelper.testSort("dusty.algo.BubbleSort",array6);

        // 测试3 测试完全有序的数组
        // 对于完全有序的数组，冒泡排序法也将成为O(n)级别的算法
        swapTime = 0;
        N= 10000000;    // 由于插入排序法和冒泡排序法在完全有序的情况下都将成为O(n)算法
        // 所以我们的测试数据规模变大，为1000,0000
        System.out.println("Test for ordered array, size = " + N);

        Integer[] array7 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        Integer[] array8 = Arrays.copyOf(array7, array7.length);
        Integer[] array9 = Arrays.copyOf(array7, array7.length);

        // 在这种情况下，不再测试选择排序算法
        SortTestHelper.testSort("dusty.algo.InsertionSort", array7);
        SortTestHelper.testSort("dusty.algo.BubbleSort", array8);


    }
}
