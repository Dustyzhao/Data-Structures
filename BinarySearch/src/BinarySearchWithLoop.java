/**
 * 二分查找法--循环实现
 * 若查找到目标元素，则返回其在数组中的索引，否则，返回-1；同时都会告知用户，算法自身查找的次数。
 * 防止极端情况下的整型溢出，应对mid做些许处理
 *
 * @author DUSTY
 */
public class BinarySearchWithLoop {

    /**
     * 在有序数组中使用二分查找法查找目标元素
     *
     * @param arr    目的数组
     * @param target 目标元素
     * @return 目标元素在目的数组中的索引，若没找到，返回-1
     */
    public static int binarySearch(Comparable[] arr, Comparable target) {

        //在arr[l,...,r]中查找target，查找了count次
        int l = 0, r = arr.length - 1, count = 0;
        //循环终止条件：l> r
        while (l <= r) {
//            int mid = (l + r) / 2;
            // 防止极端情况下的整型溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                count += 1;
                System.out.println("查找了：" + count + "次");
                return mid;
            } else if (target.compareTo(arr[mid]) < 0) {
                count += 1;
                r = mid - 1;
            } else {
                count += 1;
                l = mid + 1;
            }
        }
        System.out.println("查找了：" + count + "次");
        return -1;
    }

    /**
     * 测试二分查找法的正确性
     *
     * @param args
     */
    public static void main(String[] args) {

        int n = 10;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        int i = binarySearch(arr, 10);
        System.out.println("目标元素所处目的数组的位置：索引" + i);
    }
}
