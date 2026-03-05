// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("\n=== 확장된 동물원 관리 시스템 ===");
            System.out.printf("현재 등록된 동물: 총 %d마리\n", zoo.getAnimalCount());
            System.out.println("1. 동물 등록");
            System.out.println("2. 동물 목록 보기");
            System.out.println("3. 동물과 놀기 (사육사 필요)");
            System.out.println("4. 먹이주기");
            System.out.println("5. 특별 능력 사용");
            System.out.println("6. 사육사 관리");
            System.out.println("7. 통계 보기");
            System.out.println("8. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 8) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("이름: "); String name = scanner.nextLine();
                    System.out.print("나이: "); int age = scanner.nextInt(); scanner.nextLine();
                    System.out.println("종류 (1.강아지 2.사자 3.코끼리 4.독수리 5.펭귄 6.뱀): ");
                    int type = scanner.nextInt(); scanner.nextLine();

                    if (type == 1) zoo.addAnimal(new Dog(name, age));
                    else if (type == 2) zoo.addAnimal(new Lion(name, age));
                    else if (type == 3) zoo.addAnimal(new Elephant(name, age));
                    else if (type == 4) zoo.addAnimal(new Eagle(name, age));
                    else if (type == 5) zoo.addAnimal(new Penguin(name, age));
                    else if (type == 6) zoo.addAnimal(new Snake(name, age));
                    break;

                case 2:
                    zoo.showAllAnimals();
                    break;

                case 3: // 놀아주기
                    if (zoo.showAllAnimals()) {
                        System.out.print("동물 선택: ");
                        int idx = scanner.nextInt() - 1; scanner.nextLine();
                        zoo.interactWithAnimal(idx);
                    }
                    break;

                case 4: // 먹이주기
                    if (zoo.showAllAnimals()) {
                        System.out.print("동물 선택: ");
                        int idx = scanner.nextInt() - 1; scanner.nextLine();
                        System.out.println("먹이 종류 (1.육류 2.어류 3.식물 4.견과류): ");
                        int foodChoice = scanner.nextInt(); scanner.nextLine();

                        Food food = null;
                        if (foodChoice == 1) food = Food.MEAT;
                        else if (foodChoice == 2) food = Food.FISH;
                        else if (foodChoice == 3) food = Food.PLANT;
                        else if (foodChoice == 4) food = Food.NUT;

                        if (food != null) zoo.feedAnimal(idx, food);
                    }
                    break;

                case 5: // 특별 능력
                    if (zoo.showAllAnimals()) {
                        System.out.print("특별 능력을 사용할 동물을 선택하세요: ");
                        int idx = scanner.nextInt() - 1; scanner.nextLine();
                        zoo.useSpecialAbility(idx);
                    }
                    break;

                case 6: // 사육사 관리
                    System.out.print("사육사 이름: ");
                    String keeperName = scanner.nextLine();
                    System.out.print("전문 분야 (포유류 / 조류 / 파충류): ");
                    String specialty = scanner.nextLine();
                    zoo.setZooKeeper(new Zookeeper(keeperName, specialty));
                    break;

                case 7: // 통계
                    zoo.printStatistics();
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}