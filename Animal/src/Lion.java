public class Lion extends Mammal {
    public Lion(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 어흥!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.MEAT; }
    @Override public String toString() { return "사자"; }
}