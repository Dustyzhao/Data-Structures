package dusty.algo;

import java.util.*;

/**
 * 使用Comparable接口实现的选择排序
 * @author DUSTY
 */
public class SelectionSort {

    public static void sort(Comparable[] arr) {

        for (int i = 0;i < arr.length - 1 ; i ++){
            // 寻找[i, n)区间里的最小值的索引
            // 假设当前索引对应的是最小值
            int minIndex = i;
            //依次与其后的值进行大小对比，如果比当前值arr[i]小，则交换位置，从而找到本次循环的最小值
            for (int j = i+1 ;j < arr.length;j ++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }

    }

    /**
     * 交换位置方法实现：两个数字按从小到大的顺序排列起来
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        // 测试Integer
        Integer[] arrInteger = {10,9,8,7,6,5,4,3,2,1};
        sort(arrInteger);
        for (int i = 0; i < arrInteger.length; i++) {

            System.out.print(arrInteger[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Integer
        Double[] arrDouble = {4.4, 3.3, 2.2, 1.1};
        sort(arrDouble);
        for (int i = 0; i < arrDouble.length; i++) {

            System.out.print(arrDouble[i]);
            System.out.print(' ');
        }
        System.out.println();

        //测试自定义student类型的比较
        Student[] student = new Student[4];
        student[0] = new Student("D",90);
        student[1] = new Student("C",100);
        student[2] = new Student("B",95);
        student[3] = new Student("A",95);
        sort(student);
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i]);
        }
    }
}
