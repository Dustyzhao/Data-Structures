package dusty.algo;

import java.util.Arrays;

/**
 * 比较MergeSort和两种QuickSort排序算法的性能效率
 * 对于包含有大量重复数据的数组, 三路快排有巨大的优势
 * 对于一般性的随机数组(双路快排最快)和近乎有序的数组（三路快排比其他两种慢2倍）, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里
 * 因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。
 *
 * 下面是无大偏差的一组测试结果，以供参考：
 *      测试三种算法对随机数组的排序性能，数组的长度为：1000000,范围：[0,1000000]
 *          MergeSort : 1072ms
 *          QuickSort2ways : 435ms
 *          QuickSort3Ways : 795ms
 *      测试三种算法对拥有大量重复元素的随机数组的排序性能，数组的长度为：1000000,范围：[0,10]
 *          MergeSort : 509ms
 *          QuickSort2ways : 137ms
 *          QuickSort3Ways : 56ms
 *      测试三种算法对近乎有序数组的排序性能，数组的长度为：1000000 , swap time =100
 *          MergeSort : 62ms
 *          QuickSort2ways : 59ms
 *          QuickSort3Ways : 157ms
 *
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int N = 1000000;

        //测试1，对于随机数组，双路快排效率更高
        System.out.println("测试三种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ N +"]");

        Integer[] array1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);
        Integer[] array3 = Arrays.copyOf(array1, array1.length);

//        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.MergeSort", array1);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array2);
        SortTestHelper.testSort("dusty.algo.QuickSort3Ways", array3);
//        SortTestHelper.printArray(array2);

        // 测试2，对于随机数组且包含大量重复元素，三路快排效率最高
        System.out.println("测试三种算法对随机数组的排序性能，数组的长度为："+ N + ",范围：[0,"+ 10 +"]");

        Integer[] array7 = SortTestHelper.generateRandomArray(N,0,10);
        Integer[] array8 = Arrays.copyOf(array7, array7.length);
        Integer[] array9 = Arrays.copyOf(array7, array7.length);

//        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.MergeSort", array7);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array8);
        SortTestHelper.testSort("dusty.algo.QuickSort3Ways", array9);
//        SortTestHelper.printArray(array2);

        /**
         * 测试3，测试对近乎有序数组的排序效率
         * 对于近乎有序的数组, 三路快排最慢
         */

        int swapTime = 100;
        System.out.println("测试两种算法对近乎有序数组的排序性能，数组的长度为：" + N + " , swap time =" + swapTime);

        Integer[] array4 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        Integer[] array5 = Arrays.copyOf(array4, array4.length);
        Integer[] array6 = Arrays.copyOf(array4, array4.length);

        SortTestHelper.testSort("dusty.algo.MergeSort", array4);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways", array5);
        SortTestHelper.testSort("dusty.algo.QuickSort3Ways", array6);
//        SortTestHelper.printArray(array5);

    }
}
