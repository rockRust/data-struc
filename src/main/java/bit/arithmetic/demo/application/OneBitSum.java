package bit.arithmetic.demo.application;

/**
 * create at:  2019-07-25  17:33
 *  111100000
 *  111000000
 * @author : js
 * @description: 位1的个数（汉明重量）
 * @eg:
 */
public class OneBitSum {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * 8 : 1000
         */
        int i = hammingWeight(8);
        System.out.println(i);
    }
}
