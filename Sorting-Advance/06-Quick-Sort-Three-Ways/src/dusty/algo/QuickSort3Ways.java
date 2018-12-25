package dusty.algo;

/**
 * 三路快排的实现
 *
 * @author DUSTY
 */
public class QuickSort3Ways {

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     *
     * @param arr 待排序数组
     * @param l   数组左一
     * @param r   数组右一
     */
    private static void sort(Comparable[] arr, int l, int r) {

        //对于小规模数据(此处假设为15)，采用插入排序效果更好
        int n = 15;
        if (r - l < n) {
            InsertionSort.sort(arr, l, r);
            //插入排序完成后，直接返回即可，不加return的话，依然会进入下面的快速排序过程，导致栈溢出。
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        //定义三个变量，来标记序列范围,注意其初始化值一定要符合定义，非常重要
        //arr[l,...,lt] < v
        int lt = l;
        //arr[gt,...,r] > v
        int gt = r + 1;
        //arr[lt+1,...,i) == v
        int i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, lt + 1, i);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    /**
     * 供外部调用使用
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 交换元素位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 测试三路快排
     * @param args
     */
    public static void main(String[] args){
//        int n = 1000000;
//        Integer[] array = SortTestHelper.generateRandomArray(n, 0, 100000);
//        Integer[] array1 = SortTestHelper.generateNearlyOrderedArray(n, 100);
        Integer[] array = {5,0,0,0,3,2};
        SortTestHelper.testSort("dusty.algo.QuickSort3Ways",array);
//        SortTestHelper.testSort("dusty.algo.QuickSort3Ways",array1);
        SortTestHelper.printArray(array);
    }

}

