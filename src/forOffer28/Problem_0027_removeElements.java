package forOffer28;

/**
 * @author ：Juli
 * @date ： 2023/3/27 8:19 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Problem_0027_removeElements {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer< nums.length; fastPointer++){
            if (nums[fastPointer] != val){
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }
        }
        return slowPointer;

    }
}
