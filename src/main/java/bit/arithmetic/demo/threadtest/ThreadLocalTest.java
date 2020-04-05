package bit.arithmetic.demo.threadtest;

import bit.arithmetic.demo.single.Single;

/**
 * @author jiaosong
 * @desc
 * @date 2020/3/17
 */
public class ThreadLocalTest {

    ThreadLocal<Single.Student> param = new ThreadLocal<>();

    static
    Single.Student student = new Single.Student();

    public void testSet(String string) {
        param.set(student);
    }

    public Single.Student testChangeName(String name) {
        Single.Student student = param.get();
        student.name = name;
        return student;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int flag = i;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalTest test = new ThreadLocalTest();
                    test.testSet("thread" + flag);
                    String s = test.testChangeName();
                    System.out.print("thread name:" + Thread.currentThread().getName());
                    System.out.println(s);
                }
            });
            thread1.start();
        }
    }
}
