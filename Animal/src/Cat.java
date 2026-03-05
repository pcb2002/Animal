public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + ": 야옹!");
    }

    @Override
    public String toString() {
        return "고양이";
    }
}