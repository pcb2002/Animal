import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("\n=== 동물원 관리 시스템 ===");
            System.out.println("1. 동물 등록");
            System.out.println("2. 동물 목록 보기");
            System.out.println("3. 동물과 놀기");
            System.out.println("4. 먹이주기");
            System.out.println("5. 동물 상태 확인");
            System.out.println("6. 울음소리 듣기");
            System.out.println("7. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                continue;
            }

            if (choice == 7) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("동물 이름을 입력하세요: ");
                    String name = scanner.nextLine();

                    int age = 0;
                    try {
                        System.out.print("동물 나이를 입력하세요: ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("나이는 숫자로 입력해야 합니다. 처음부터 다시 시도해주세요.");
                        scanner.nextLine();
                        break;
                    }

                    System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
                    String type = scanner.nextLine();

                    if (type.equals("1")) {
                        zoo.addAnimal(new Dog(name, age));
                    } else if (type.equals("2")) {
                        zoo.addAnimal(new Cat(name, age));
                    } else {
                        System.out.println("잘못된 동물 종류입니다.");
                    }
                    break;

                case 2:
                    zoo.showAllAnimals();
                    break;

                case 3:
                case 4:
                case 5:
                case 6:
                    if (!zoo.showAllAnimals()) break;

                    int animalIndex = -1;
                    try {
                        System.out.print("동물을 선택하세요: ");
                        animalIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        scanner.nextLine();
                        break;
                    }

                    if (animalIndex < 0 || animalIndex >= zoo.getAnimalCount()) {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    if (choice == 3) zoo.playWithAnimal(animalIndex);
                    else if (choice == 4) zoo.feedAnimal(animalIndex);
                    else if (choice == 5) zoo.showAnimalStatus(animalIndex);
                    else zoo.makeAnimalSound(animalIndex);
                    break;

                default:
                    System.out.println("1~7 사이의 메뉴를 선택해주세요.");
            }
        }
        scanner.close();
    }
}