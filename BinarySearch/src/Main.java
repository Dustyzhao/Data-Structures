import com.sun.xml.internal.bind.v2.TODO;

/**
 * 比较循环和递归写法的二分查找的效率
 * 按理说，递归存在函数调用等的额外时间花销，但是不知怎么第，我没测（看）出来，日后再完善吧
 *
 * @author DUSTY
 */
public class Main {
    public static void main(String[] args) {

        //TODO 完善测试用例，当前无法测出两种不同实现的效率差别

        int n = 1000000;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
//            System.out.print(arr[i]);
//            System.out.print(" ");
        }
        long startTime1 = System.currentTimeMillis();
        int i = BinarySearchWithLoop.binarySearch(arr, 13);
        long endTime1 = System.currentTimeMillis();
        long time1 = endTime1 - startTime1;
        System.out.println("目标元素所处目的数组的位置：索引" + i + " " + "循环实现的二分查找法的执行时间：" + time1 + "ms");


        long startTime2 = System.currentTimeMillis();
        int j = BinarySearchWithRecursion.binarySearch(arr, 13);
        long endTime2 = System.currentTimeMillis();
        long time2 = endTime2 - startTime2;
        System.out.println("目标元素所处目的数组的位置：索引" + j + " " + "递归实现的二分查找法的执行时间：" + time2 + "ms");
    }
}
