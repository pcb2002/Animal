public class Snake extends Reptile {
    public Snake(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 스으으..."); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.MEAT; }
    @Override public String toString() { return "뱀"; }
}