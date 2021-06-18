package bit.arithmetic.demo.datastructure.dynamic_40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaosong
 * @desc 硬币凑钱问题 leetcode:322
 * @date 2021/6/17
 */
public class CoinSolution {

    static Map<Integer, Integer> mem = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return -1;
        }

        if (Arrays.stream(coins).anyMatch(coinAmount -> coinAmount == amount)) {
            return 1;
        }
        Integer memAmount = mem.get(amount);
        if (memAmount != null) {
            return memAmount;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int round = coinChange(coins, amount - coins[i]);
            if (round < min && round != -1) {
                min = round;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        mem.put(amount, min + 1);
        return min + 1;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int coin = coinChange(coins, 3);
        System.out.println("result:" + coin);
    }
}
