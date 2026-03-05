public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + ": 멍멍!");
    }

    @Override
    public String toString() {
        return "강아지";
    }
}