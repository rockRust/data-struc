package bit.arithmetic.demo;

/**
 * create at:  2019-07-25  16:19
 *
 * @author : js
 * @description: 简单应用
 */
public class SimpleApplication {

    /**
     * 判断奇偶
     * 0000
     * 00001 :0
     * :1
     *
     * @return
     */
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    /**
     * 清掉最后一个1
     * 101000000 -> 1000
     * 1001
     *
     * @param n
     * @return
     */
    public static int delLastOne(int n) {
        return n & (n - 1);
    }

    /**
     * 获得最后一个1
     * 1010 相反数的补码为  0110 再取与 10
     * 0110
     * 10
     * ~(n-1)
     *
     * @param n
     * @return
     */
    public static int getLastOne(int n) {
        return n & -n;
    }


    public static void main(String[] args) {

//        boolean result = isEven(5);
//        System.out.println(result);
//
//        int i = delLastOne(6);
//        System.out.println(i);
//
//        int lastOne = getLastOne(10);
//        System.out.println(lastOne);

        //交换两个数的值
        int a = -1, b = -2;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
