import java.util.ArrayList;
import java.util.Random;

/**
 * 测试用例
 * @author DUSTY
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        BST<Integer> bst1 = new BST<>();

        //随机向二分搜索树中添加元素，然后删除最小值
        //删除最大值同理，不再赘述

        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        //用一个动态数组来存储从BST中删除的最小元素
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        //验证nums中确实是从小到大排序的
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        //证明确实每次删除的都是当时BST中最小的元素
        System.out.println("removeMin test completed.");

        bst1.add(32);
        bst1.add(1);
        bst1.add(2);
        System.out.println(bst1);
        bst1.remove(32);
        System.out.println(bst1);
//        int[] nums = {5,3,6,8,4,2};
//        for(int num:nums){
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//
//        bst.levelOrder();
//        bst.preOrderNR();
        //System.out.println(bst);
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
    }

}
