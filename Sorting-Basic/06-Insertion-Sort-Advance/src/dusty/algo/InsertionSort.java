package dusty.algo;

/**
 * 改良后的插入算法
 * 不再进行元素之间的值交换，而是进行值覆盖，这样每次符合条件的比较就节省2次赋值行为。
 * 并可以提前终止内层循环：终止的条件是该元素找到了其合适的位置，所以我们推测，在近乎有序的序列中，插入排序的效率会更高
 * @author DUSTY
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {
            //寻找arr[i]合适的存放位置
            Comparable e = arr[i];
            //j保存e应该存放的位置
            int j = i;
            for ( j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--) {

                arr[j] = arr[j - 1];
            }
            //j的一次循环完毕之后，说明arr[j]已找到自己合适的位置，此时就是e的位置。
            arr[j] = e;
        }
    }



    /**
     * 测试InsertionSort
     * @param args
     */
    public static void main(String[] args){

        int N = 20000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.printArray(array);
        SortTestHelper.testSort("dusty.algo.InsertionSort",array);
        SortTestHelper.printArray(array);
    }
}
