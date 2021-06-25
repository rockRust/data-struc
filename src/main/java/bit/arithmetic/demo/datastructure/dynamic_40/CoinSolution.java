package bit.arithmetic.demo.datastructure.dynamic_40;

import java.util.Arrays;

/**
 * @author jiaosong
 * @desc 硬币凑钱问题 leetcode:322
 * @date 2021/6/17
 */
public class CoinSolution {

    static int maxAmount = 0;

    static int[] mem;

    public static int coinChange(int[] coins, int amount) {
        if (amount > maxAmount) {
            maxAmount = amount;
            mem = new int[maxAmount + 1];
        }

        if (amount < 1) {
            return -1;
        }

        if (Arrays.stream(coins).anyMatch(coinAmount -> coinAmount == amount)) {
            return 1;
        }
        Integer memAmount = mem[amount];
        if (memAmount != 0) {
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
        mem[amount] = min + 1;
        return min + 1;
    }


    public static int second(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        // int[] coins = {1, 2, 5};
        int coin = second(coins, 6249);
        // int coin = second(coins, 11);
        System.out.println("result:" + coin);
    }
}
