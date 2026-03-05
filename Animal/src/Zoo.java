import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();
    private Zookeeper currentKeeper;

    public void setZooKeeper(Zookeeper keeper) {
        this.currentKeeper = keeper;
        System.out.println("[" + keeper.getSpecialty() + " 전문] " + keeper.getName() + " 사육사가 배치되었습니다.");
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.printf("%s(%s, %d살)가 등록되었습니다.\n", animal.getName(), animal.toString(), animal.getAge());
    }

    public boolean showAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다.");
            return false;
        }
        for (int i = 0; i < animals.size(); i++) {
            System.out.printf("%d. %s (%s) - 배고픔:%d, 행복도:%d\n",
                    (i + 1), animals.get(i).getName(), animals.get(i).toString(),
                    animals.get(i).getHunger(), animals.get(i).getHappiness());
        }
        return true;
    }

    public void interactWithAnimal(int index) {
        if (currentKeeper == null) {
            System.out.println("사육사가 없습니다! 먼저 사육사를 배치해주세요.");
            return;
        }
        currentKeeper.playWith(animals.get(index));
    }

    public void feedAnimal(int index, Food food) {
        animals.get(index).eat(food);
    }

    public void useSpecialAbility(int index) {
        Animal animal = animals.get(index);
        boolean hasAbility = false;

        if (animal instanceof Flyable) { ((Flyable) animal).fly(); hasAbility = true; }
        if (animal instanceof Swimmable) { ((Swimmable) animal).swim(); hasAbility = true; }
        if (animal instanceof Sprayable) { ((Sprayable) animal).sprayWater(); hasAbility = true; }

        if (!hasAbility) System.out.println(animal.getName() + "은(는) 사용할 수 있는 특별한 능력이 없습니다.");
    }

    public void printStatistics() {
        if (animals.isEmpty()) {
            System.out.println("통계를 낼 동물이 없습니다.");
            return;
        }
        int totalSum = 0;
        Animal happiest = animals.get(0);
        ArrayList<String> hungryAnimals = new ArrayList<>();

        int mammalCnt = 0, birdCnt = 0, reptileCnt = 0;

        for (Animal a : animals) {
            totalSum += a.getHappiness();
            if (a.getHappiness() > happiest.getHappiness()) happiest = a;
            if (a.getHunger() >= 70) hungryAnimals.add(a.getName() + "(" + a.toString() + ")");

            if (a instanceof Mammal) mammalCnt++;
            else if (a instanceof Bird) birdCnt++;
            else if (a instanceof Reptile) reptileCnt++;
        }

        System.out.println("\n=== 동물원 통계 ===");
        System.out.printf("- 전체 동물 수: %d마리 (포유류 %d, 조류 %d, 파충류 %d)\n", animals.size(), mammalCnt, birdCnt, reptileCnt);
        System.out.printf("- 평균 행복도: %.1f\n", (double)totalSum / animals.size());

        System.out.print("- 배고픈 동물 (배고픔 70 이상): ");
        System.out.println(hungryAnimals.isEmpty() ? "없음" : String.join(", ", hungryAnimals));

        System.out.printf("- 가장 행복한 동물: %s(%s) - 행복도 %d\n", happiest.getName(), happiest.toString(), happiest.getHappiness());
    }

    public int getAnimalCount() { return animals.size(); }
}