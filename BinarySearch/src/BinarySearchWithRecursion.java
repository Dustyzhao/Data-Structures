/**
 * 二分查找法--递归实现
 *
 * @author DUSTY
 */
public class BinarySearchWithRecursion {

    /**
     * 递归实现的二分查找法
     *
     * @param arr
     * @param l      数组起始位置索引
     * @param r      数组末尾索引
     * @param count  查找的次数
     * @param target
     * @return 若找到，返回目标元素所在目的数组中的索引值；否则，返回-1
     */
    public static int binarySearch(Comparable[] arr, int l, int r, int count, Comparable target) {

        /**
         * 1.判断传入的初始数组是否为空，为空则返回-1；
         * 2.判断arr中是否存在target，若不存在，在递归末会出现l＞r的情况，此时依然会返回-1。
         * 由count的值来判断初始数组为空(count == 0)or目标元素未找到(count > 0)
         */
        if (l > r) {
            System.out.println("查找了：" + count + "次");
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (target.compareTo(arr[mid]) == 0) {
            System.out.println("查找了：" + (count += 1) + "次");
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return binarySearch(arr, l, mid - 1, count += 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, count += 1, target);
        }
    }

    /**
     * 暴露的接口
     *
     * @param arr    目的数组
     * @param target 查找的目标元素
     * @return 若找到，返回目标元素所在目的数组中的索引值；否则，返回-1
     */
    public static int binarySearch(Comparable[] arr, Comparable target) {
        return binarySearch(arr, 0, arr.length - 1, 0, target);
    }

    /**
     * 测试二分查找法的正确性
     *
     * @param args
     */
    public static void main(String[] args) {

        int n = 0;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        int i = binarySearch(arr, 11);
        System.out.println("目标元素所处目的数组的位置：索引" + i);
    }
}
