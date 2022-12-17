package elementary02;

/**
 * @PROJECT:从1-5随机到1-7随机
 * @DESCRIPTION:
 * @USER: Elizabeth
 * @DATE: 2022/12/17 17:21
 */
public class Code02_rand2 {


    // 随机返回一个正整数属于1-5区间范围内
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }


    // 等概率返回0和1
    // 如果f1的结果是3，舍弃重调f1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);

        return ans < 3 ? 0 : 1;
    }

    // 000~~111等概率返回 也就是0--7等概率返回
    public static int f3() {
        return ((f2() << 2) + (f2() << 1) + f2());
    }

    // 0--6等概率返回
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    // 1--7等概率返回
    public static int f5() {
        return f4() + 1;
    }

    // 黑盒 不确定里面的0 和 1 的比例如何
    public static int x(){
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 如果得到00 和 11 舍弃
    // 只有 01 或 10 才能返回
    // 得到等概率返回
    public static int equalProbability(){
        int ans =0;
        do{
            ans = x();
        }while (ans == x());
        return ans;
    }

    public static void main(String[] args) {
        int count = 0;
        int testTime = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTime);

        System.out.println("++++++++++++++++");

        int[] counts = new int[8];
        for (int i = 0; i < testTime; i++) {
            int num = f3();
            counts[num]++;
        }
        for (int j = 0; j < 8; j++) {
            System.out.println(j + "出现了" + counts[j] + "次");
        }

        System.out.println("++++++++++++++++");

        count = 0;
        for(int i = 0; i < 100000; i ++){
            if(equalProbability() == 0){
                count++;
            }
        }
        System.out.println((double)count / (double)100000);
    }

}
