package elementary02;

/**
 * @PROJECT: 使用Math.random()方法得到x的平方、三次方
 * @DESCRIPTION:
 * @USER: Elizabeth
 * @DATE: 2022/12/17 12:15
 */
public class Code01_randTest {

    public static void main(String[] args) {
        int testTime = 10000000;
        int count = 0;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTime);

        System.out.println("+=============+");

        int count2 = 0;
        for (int i = 0; i < testTime; i++) {
            // Math.random() * 8 返回的是[0, 8) 上任意值，注意，左闭右开！
            if (Math.random() * 8 < 4) {
                count2++;
            }
        }
        System.out.println((double) count2 / (double) testTime);

        System.out.println("+=============+");

        // 此处ans的范围是[0, k-1]，左闭右闭。
//        int K = ?;
//        int ans = (int) (Math.random() * K);

        int K = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTime; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }

        System.out.println("+=============+");

        count =0;
        double x = 0.7;

        for (int i = 0; i < testTime; i++) {
            if(squareOfx() < x)
            count++;
        }
        System.out.println((double)count / (double)testTime);
        System.out.println(Math.pow(x, 2));

        System.out.println("+=============+");


        count =0;
        for (int i = 0; i < testTime; i++) {
            if(cubeOfx() < x)
                count++;
        }
        System.out.println((double)count / (double)testTime);
        System.out.println(Math.pow(x, 3));

    }
    public static double squareOfx(){
        return Math.max(Math.random(), Math.random());
    }

    public static double cubeOfx(){
        return Math.max(Math.random(), Math.max(Math.random(),Math.random()));
    }
}
