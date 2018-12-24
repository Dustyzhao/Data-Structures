package dusty.algo;

/**
 * 双路快速排序
 * @author DUSTY
 */
public class QuickSort2ways {

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
     * partitoning process：双路快排的partition过程
     *  把选定的元素移动到其应处于的位置上（排好序后）
     *  使得其之前的元素都<该元素<其后所有元素
     * @param arr
     * @param l
     * @param r
     * @return 选定元素的位置
     */
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点v
        swap( arr,l, (int) (Math.random()*(r-l+1)) + l );
        Comparable v = arr[l];

        //定义i、j，使其满足arr[l+1,i) <= v;arr(j,r] >= v
        int i = l+1,j = r;
        while (true) {

            //注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            //考虑到特殊情况，如{5,0,0,...,0,6,6},
            //  循环停止条件< 0可保证i，j的及时交换（纵然是i==j），从而序列两段（< 0和> 0）内元素个数保持最大程度均衡。
            //  循环停止条件<= 0时，如上举例的数组，循环只会在数组倒数第二个元素时停止，而此时< 0的部分元素个数显然是极度不均衡的。
            while (arr[i].compareTo(v) < 0 && i <= r) {
                i++;
            }
            while (arr[j].compareTo(v) > 0 && j >= l + 1) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
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

        int N = 10000;
//        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] array = {5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        SortTestHelper.printArray(array);
        SortTestHelper.testSort("dusty.algo.QuickSort2ways",array);
        SortTestHelper.printArray(array);
    }
}
