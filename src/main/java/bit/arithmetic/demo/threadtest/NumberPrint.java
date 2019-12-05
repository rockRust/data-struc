package bit.arithmetic.demo.threadtest;

/**
 * create at:  2019-11-26  13:12
 *
 * @author : js
 * @description: 基于一个锁和一个状态变量实现连续打印abcabc...
 */
public class NumberPrint {

    private volatile int state;

    private static final int PRINT_TIME = 5;

    private class Print implements Runnable {

        private int myState;
        private int nextState;
        private String printString;
        private final Object lock;


        public Print(Object lock, int myState, int nextState, String printString) {
            this.lock = lock;
            this.myState = myState;
            this.nextState = nextState;
            this.printString = printString;
        }

        @Override
        public void run() {
            for (int i = 0; i < PRINT_TIME; i++) {
                synchronized (lock) {
                    while (state != myState) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    System.out.println(printString);
                    state = nextState;
                    lock.notifyAll();
                }
            }
        }
    }

    public void test() {
        Object lock = new Object();
        Print a = new Print(lock, 0, 1, "A");
        Print b = new Print(lock, 1, 2, "B");
        Print c = new Print(lock, 2, 0, "C");

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        Thread threadC = new Thread(c);
        threadA.start();
        threadB.start();
        threadC.start();

    }


    public static void main(String[] args) {
        NumberPrint n = new NumberPrint();
        n.test();
    }
}
