package forOffer29;

/**
 * @author ：Juli
 * @date ： 2023/3/27 7:58 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class Problem_0367_ValidPerfectSquare {


    public boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }
        double N = (double) num;

        long L = 1;
        long R = num;
        long M = 1;
        long ans = 1;
        while (L <= R) {
            M = L + ((R - L) / 2);
            if (M * M <= num){
                ans = M;
                L = M +1;
            }else {
                R = M -1;
            }
        }
        return (ans*ans==num) ? true : false;

    }
}
