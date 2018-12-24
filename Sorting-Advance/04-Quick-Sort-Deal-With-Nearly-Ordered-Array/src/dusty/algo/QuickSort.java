package dusty.algo;

/**
 * 快速排序
 * @author DUSTY
 */
public class QuickSort {

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     * @param arr 待排序数组
     * @param l 数组左一
     * @param r 数组右一
     */
    public static void sort(Comparable[] arr,int l,int r) {

//        if (l >= r) {
//            return;
//        }

        //对于小规模数据(此处假设为15)，采用插入排序效果更好
        int n = 15;
        if (r - l <= n) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int p = partition(arr, l, r);
        //p经过一轮partition后已经处于其应放位置，故递归范围应该是到p-1为止
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    /**
     * partitoning process：
     *  把选定的元素移动到其应处于的位置上（排好序后）
     *  使得其之前的元素都<该元素<其后所有元素
     * @param arr
     * @param l
     * @param r
     * @return 选定元素的位置
     */
    private static int partition(Comparable[] arr, int l, int r) {

        //所选元素(序列的第一位元素)标记为v
        Comparable v = arr[l];
        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        //System.out.println("j="+ j);
        for (int i = l + 1; i <= r; i++) {
            //因为标记位已经是序列的第一位，所以我们只需把小于它的元素放到它的前面即可。
            if (arr[i].compareTo(v) < 0) {
                //System.out.println("j= "+j);
                j ++;
                //System.out.println("j=  "+j);
                //经过j++之后，此时已经是j+=1之后的了，所以下面不传入j+1，而是j。
                swap(arr,j,i);
            }
        }
        //一次partition之后，需要把v放到适当位置
        swap(arr,l,j);
        return j;
    }

    /**
     * 交换元素位置
     * @param arr
     * @param j
     * @param i
     */
    private static void swap(Object[] arr, int j, int i) {
        Object t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    /**
     * 外部调用接口
     */
    public static void sort(Comparable[] arr) {

        sort(arr,0,arr.length - 1);
    }

    /**
     * 测试 QuickSort
     * @param args
     */
    public static void main(String[] args){

        int N = 10;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 10);
//        Integer[] array = {5,0,1,3,2};
        SortTestHelper.printArray(array);
        SortTestHelper.testSort("dusty.algo.QuickSort",array);
        SortTestHelper.printArray(array);
    }
}
