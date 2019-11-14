package bit.arithmetic.demo.statictest;

/**
 * create at:  2019-11-14  14:15
 *
 * @author : js
 * @description:
 */
public class Dog extends Animal {
    static {
        System.out.println("dog static code");
    }

    {
        System.out.println("dog general code");
    }

    public Dog() {
        System.out.println("dog constructor method");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog();
    }
}
