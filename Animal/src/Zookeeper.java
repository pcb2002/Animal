public class Zookeeper {
    private String name;
    private String specialty; // "포유류", "조류", "파충류"

    public Zookeeper(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public void playWith(Animal animal) {
        boolean isSpecialist = false;
        if (specialty.equals("포유류") && animal instanceof Mammal) isSpecialist = true;
        if (specialty.equals("조류") && animal instanceof Bird) isSpecialist = true;
        if (specialty.equals("파충류") && animal instanceof Reptile) isSpecialist = true;

        if (isSpecialist) {
            System.out.println("전문 사육사 " + name + "이(가) 능숙하게 놀아줍니다!");
            animal.play(30); // 전문가 버프
        } else {
            System.out.println("사육사 " + name + "이(가) 열심히 놀아줍니다.");
            animal.play(10);
        }
        System.out.println(animal.getName() + "의 현재 행복도: " + animal.getHappiness());
    }

    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
}