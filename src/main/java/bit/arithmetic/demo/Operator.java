package bit.arithmetic.demo;

/**
 * create at:  2019-07-25  11:13
 *
 * @author : js
 * @description: 运算符
 */
public class Operator {
    public static void main(String[] args) {
        /**
         * 一个字节（B）占八位二进制（比特 bit），一个整数占四个字节
         * 5: 00000000 00000000 00000000 00000101
         * 6: 00000000 00000000 00000000 00000110
         */
        int a = 5, b = 6;

        /** 按位与
         *  100
         */
        int result = a & b;
        System.out.println("按位与结果: " + result);

        /**按位或
         * 111
         */
        result = a | b;
        System.out.println("按位或结果: " + result);

        /**按位异或
         * 011
         */
        result = a ^ b;
        System.out.println("按位异或结果: " + result);

        /**按位取反
         * 11111010
         * 负整数补码求原码：取反加一
         */
        result = ~a;
        System.out.println("按位取反结果: " + result);

        /**左移
         * 20
         */
        result = a << 2;
        System.out.println("左移两位结果: " + result);

        /**右移
         * 1
         */
        result = a >> 2;
        System.out.println("右移两位结果: " + result);

        /**
         *
         */

    }
}
