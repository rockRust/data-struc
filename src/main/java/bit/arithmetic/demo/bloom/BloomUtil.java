package bit.arithmetic.demo.bloom;

import com.google.common.hash.BloomFilter;

/**
 * @author jiaosong
 * @desc
 * @date 2020/8/19
 */
public class BloomUtil {
  public static void main(String[] args) {
        // 预估数据量：100000 个元素
        int expectedInsertions = 100_000;
        // 期望的误判率：1%
        double falsePositiveProbability = 0.01;

        // 创建布隆过滤器
        BloomFilter<String> bloomFilter = BloomFilter.create(
            Funnels.stringFunnel(java.nio.charset.StandardCharsets.UTF_8),
            expectedInsertions,
            falsePositiveProbability
        );

        // 添加元素
        bloomFilter.put("user1@example.com");
        bloomFilter.put("user2@example.com");
        bloomFilter.put("user3@example.com");

        // 检查元素是否存在
        System.out.println(bloomFilter.mightContain("user1@example.com")); // true
        System.out.println(bloomFilter.mightContain("user4@example.com")); // false（可能为 true，误判）
        System.out.println(bloomFilter.mightContain("not-exist@xxx.com")); // false
    }
}

