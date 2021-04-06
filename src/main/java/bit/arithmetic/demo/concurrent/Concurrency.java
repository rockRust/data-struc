package bit.arithmetic.demo.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiaosong
 * @desc
 * @date 2021/4/2
 */
public class Concurrency {
    public static void main(String[] args) {
//        ConcurrentHashMap<Object, Object> location = new ConcurrentHashMap<>();
//        location.put("1", 1);
//        location.put("2", 2);
//        Map<Object, Object> objectObjectMap = Collections.unmodifiableMap(location);
//        System.out.println("result:" + objectObjectMap.get("1"));
//        location.put("1", 3);
//        System.out.println("result:" + objectObjectMap.get("1"));

        String s = "222;333;333;444";
        String[] split = s.split(";");
        String remove = "333";
        List<String> list = Arrays.asList(split);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(remove)) {
                iterator.remove();
            }
        }
        System.out.println("" + list);
    }
}
