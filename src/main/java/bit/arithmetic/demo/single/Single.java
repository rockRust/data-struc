package bit.arithmetic.demo.single;

import java.util.ArrayList;
import java.util.List;

/**
 * create at:  2019-12-04  15:08
 *
 * @author : js
 * @description: 单例 double-check
 */
public class Single {


    private volatile Single single;

    private Single() {
    }

    public Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {

        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("1");

        Integer a = 1;
        List<Integer> ints = new ArrayList<>();
        ints.add(a);
        a = 2;
        System.out.println(ints);

        List<Student> students = new ArrayList<>();
        Student s = new Student();
        for (int i = 0; i < 10; i++) {
            s.name = String.valueOf(i);
            students.add(s);
        }
        System.out.println(students);
    }

    public static class Student {
        public String name;
    }
}
