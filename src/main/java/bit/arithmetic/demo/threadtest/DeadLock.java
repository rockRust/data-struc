package bit.arithmetic.demo.threadtest;

public class DeadLock implements Runnable {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private Thread a = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (lock1) {
                try {
                    System.out.println("a开始休眠");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("a执行完毕");
                }
            }
        }
    });

    private Thread b = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (lock2) {
                try {
                    System.out.println("b开始休眠");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("b执行完毕");
                }
            }
        }
    });

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.a.start();
        deadLock.b.start();
    }

    @Override
    public void run() {

    }
}
