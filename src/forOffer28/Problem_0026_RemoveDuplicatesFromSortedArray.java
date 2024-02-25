package forOffer28;

/**
 * @author ：Juli
 * @date ： 2023/3/27 8:35 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Problem_0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int slowPointer = 0;
//        int flag = 0;
//        for (int fastPointer =1; fastPointer< nums.length; fastPointer++){
//            if (nums[slowPointer] == nums[fastPointer]){
//                flag =1;
//                continue;
//            }
//            if (flag ==1 && nums[slowPointer] != nums[fastPointer]){
//                slowPointer++;
//                nums[slowPointer] = nums[fastPointer];
//                flag =0;
//            }else if (flag == 0 && nums[slowPointer] != nums[fastPointer]){
//                slowPointer++;
//                nums[slowPointer] = nums[fastPointer];
//            }
//        }
        for (int fastPointer = 1; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] == nums[slowPointer]){
                continue;
            }else {
                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
        }
        return slowPointer+1;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 2, 3};
        Problem_0026_RemoveDuplicatesFromSortedArray A = new Problem_0026_RemoveDuplicatesFromSortedArray();
        int i = A.removeDuplicates(ints);
        System.out.println(i);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}
