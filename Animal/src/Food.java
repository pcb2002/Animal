// Food.java (먹이 종류 Enum)
public enum Food {
    MEAT("육류"), FISH("어류"), PLANT("식물"), NUT("견과류");

    private final String foodName;
    Food(String foodName) { this.foodName = foodName; }
    public String getFoodName() { return foodName; }
}

