// Animal.java
public abstract class Animal {
    private String name;
    private int age;
    private int hunger;     // 100에 가까울수록 배고픔
    private int happiness;  // 100이 최대치

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hunger = 50;
        this.happiness = 50;
    }

    public abstract void makeSound();
    protected abstract boolean isPreferredFood(Food food);

    public void eat(Food food) {
        if (isPreferredFood(food)) {
            this.hunger -= 30;
            System.out.println(name + "이(가) " + food.getFoodName() + "을(를) 아주 맛있게 먹습니다!");
        } else {
            this.hunger -= 10;
            System.out.println("경고: " + name + "에게 적절하지 않은 먹이입니다. 마지못해 먹습니다.");
        }
        if (this.hunger < 0) this.hunger = 0;
    }

    public void play(int amount) {
        this.happiness += amount;
        if (this.happiness > 100) this.happiness = 100;
    }

    public void printStatus() {
        System.out.printf("[%s] 나이: %d살 | 배고픔: %d/100 | 행복도: %d/100\n", name, age, hunger, happiness);
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
}

