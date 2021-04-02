package bit.arithmetic.demo.concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiaosong
 * @desc
 * @date 2021/4/2
 */
public class Concurrency {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> location = new ConcurrentHashMap<>();
        location.put("1", 1);
        location.put("2", 2);
        Map<Object, Object> objectObjectMap = Collections.unmodifiableMap(location);
        System.out.println("result:" + objectObjectMap.get("1"));
        location.put("1", 3);
        System.out.println("result:" + objectObjectMap.get("1"));
    }
}
