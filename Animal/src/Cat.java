public class Cat extends Mammal {
    public Cat(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 야옹!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.MEAT || food == Food.NUT; }
    @Override public String toString() { return "고양이"; }
}