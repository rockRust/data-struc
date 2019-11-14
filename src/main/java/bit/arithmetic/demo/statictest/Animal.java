package bit.arithmetic.demo.statictest;

/**
 * create at:  2019-11-14  14:13
 *
 * @author : js
 * @description:
 */
public class Animal {
    static {
        System.out.println("animal static code");
    }

    {
        System.out.println("animal method code");
    }

    public Animal() {
        System.out.println("animal constructor method");
    }
}
