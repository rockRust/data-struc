package bit.arithmetic.demo.application;


import java.util.Arrays;

/**
 * create at:  2019-07-25  18:49
 *
 * @author : js
 * @description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @eg: 输入5 输出 [0,1,1,2,1,2]
 *
 *   n&(n-1)
 * 0 :0
 * 1: 1
 * 2:1
 *
 * 0000111110000:5
 * 0000111110001:6
 * 000011111000 ->  0000111110001
 *
 * 0:00
 * 1:01  1
 * 2:10  1
 * 3:11  2
 * 1111111011   100
 */
public class CountingBit {
    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
//        int[] bits = new int[6];
//        bits[0] = 0;
//        for (int i = 1; i < 6; i++) {
//            System.out.println(Integer.toBinaryString(i & (i - 1)) + " -> " + Integer.toBinaryString(i));
//            bits[i] = bits[i & (i - 1)] + 1;
//            System.out.println(bits[i]);
//            System.out.println("-------");
//        }
//        return bits;
    }


    public static void main(String[] args) {
        int[] ints = countBits(6);
        System.out.println(Arrays.toString(ints));
    }

}
