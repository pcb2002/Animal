public class Penguin extends Bird implements Swimmable {
    public Penguin(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 꽥꽥!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.FISH; }
    @Override public void swim() {
        System.out.println(getName() + "이(가) 얼음물에서 시원하게 헤엄칩니다!");
        play(20);
    }
    @Override public String toString() { return "펭귄"; }
}