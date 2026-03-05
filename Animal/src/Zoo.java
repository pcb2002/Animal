import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.printf("%s(%s, %d살)가 등록되었습니다.\n",
                animal.getName(), animal.toString(), animal.getAge());
    }

    // 동물이 있는지 여부 반환 (UI에서 분기 처리를 위해)
    public boolean showAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("등록된 동물이 없습니다.");
            return false;
        }
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            System.out.printf("%d. %s (%s, %d살)\n", (i + 1), a.getName(), a.toString(), a.getAge());
        }
        return true;
    }

    public void playWithAnimal(int index) {
        animals.get(index).play();
    }

    public void feedAnimal(int index) {
        animals.get(index).eat();
    }

    public void showAnimalStatus(int index) {
        animals.get(index).printStatus();
    }

    public void makeAnimalSound(int index) {
        animals.get(index).makeSound();
    }

    public int getAnimalCount() {
        return animals.size();
    }
}