package dusty.algo;

import java.util.Arrays;

/**
 *比较SelectionSort和InsertionSort两种排序算法的性能效率
 *此时插入排序略快于选择排序
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args){
        int N = 20000;

        System.out.println("测试随机数组性能，长度为："+ N + ",范围：[0,"+ N +"]");

        Integer[] array1 = SortTestHelper.generateNearlyOrderedArray(N,10);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.printArray(array1);
        SortTestHelper.printArray(array2);
        SortTestHelper.testSort("dusty.algo.SelectionSort", array1);
        SortTestHelper.testSort("dusty.algo.InsertionSort", array2);
    }
}
