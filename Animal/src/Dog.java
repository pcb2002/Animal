public class Dog extends Mammal {
    public Dog(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 멍멍!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.MEAT || food == Food.NUT; }
    @Override public String toString() { return "강아지"; }
}