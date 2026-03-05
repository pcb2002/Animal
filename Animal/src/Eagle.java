public class Eagle extends Bird implements Flyable {
    public Eagle(String name, int age) { super(name, age); }
    @Override public void makeSound() { System.out.println(getName() + ": 삐이익!"); }
    @Override protected boolean isPreferredFood(Food food) { return food == Food.MEAT; }
    @Override public void fly() {
        System.out.println(getName() + "이(가) 하늘 높이 날아올랐습니다! 행복도가 크게 증가했습니다.");
        play(30);
    }
    @Override public String toString() { return "독수리"; }
}