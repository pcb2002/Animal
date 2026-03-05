public abstract class Animal {
    private String name;
    private int age;
    private int hunger;
    private int happiness;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hunger = 50;     // 초기 배고픔 수치
        this.happiness = 50;  // 초기 행복도 수치
    }

    // 추상 메소드: 자식 클래스에서 반드시 구현해야 함 (다형성)
    public abstract void makeSound();

    public void eat() {
        this.hunger -= 20;
        if (this.hunger < 0) this.hunger = 0;
        System.out.println(this.name + "에게 먹이를 주었습니다. 배고픔이 감소합니다. (현재 배고픔: " + this.hunger + ")");
    }

    public void play() {
        this.happiness += 20;
        if (this.happiness > 100) this.happiness = 100;
        System.out.println(this.name + "와(과) 놀았습니다. 행복도가 증가합니다. (현재 행복도: " + this.happiness + ")");
    }

    public void printStatus() {
        System.out.printf("[%s] 나이: %d살 | 배고픔: %d/100 | 행복도: %d/100\n", name, age, hunger, happiness);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}