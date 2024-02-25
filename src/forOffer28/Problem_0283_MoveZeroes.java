package forOffer28;

/**
 * @author ：Juli
 * @date ： 2023/3/27 9:46 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Problem_0283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        if (nums.length == 1) {
            return ;
        }
        int slowPointer = 0;
        for (int fastPointer = 1; fastPointer<nums.length; fastPointer++){
            if (nums[slowPointer]!= 0){
                slowPointer++;
                continue;
            }
            if (nums[slowPointer] == 0 && nums[fastPointer]!=0){
                nums[slowPointer] = nums[fastPointer];
                nums[fastPointer] =0;
                slowPointer++;
            }else if (nums[slowPointer] == 0 && nums[fastPointer]==0 ){
                continue;
            }
        }
    }
}
