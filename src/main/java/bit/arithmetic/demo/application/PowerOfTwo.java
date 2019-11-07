package bit.arithmetic.demo.application;

/**
 * create at:  2019-07-25  18:29
 *
 * @author : js
 * @description: 判断一个数是否是二的幂次方
 */
public class PowerOfTwo {
    /**
     * 判断一个数是否是二的幂次方
     * 0000000010000
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(1);
        System.out.println(powerOfTwo);
    }
}
