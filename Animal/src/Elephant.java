public class Elephant extends Mammal implements Sprayable {
    public Elephant(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 뿌우!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.PLANT || food == Food.NUT; }
    @Override public void sprayWater() {
        System.out.println(getName() + "이(가) 코로 시원하게 물을 뿜습니다!");
        play(20);
    }
    @Override public String toString() { return "코끼리"; }
}