classDiagram
    %% 인터페이스 및 Enum 정의
    class Flyable {
        <<interface>>
        +fly() void
    }
    class Swimmable {
        <<interface>>
        +swim() void
    }
    class Sprayable {
        <<interface>>
        +sprayWater() void
    }
    class Food {
        <<enumeration>>
        MEAT
        FISH
        PLANT
        NUT
        +getFoodName() String
    }

    %% 추상 클래스 계층
    class Animal {
        <<abstract>>
        -String name
        -int age
        -int hunger
        -int happiness
        +Animal(String name, int age)
        +makeSound()* void
        #isPreferredFood(Food food)* boolean
        +eat(Food food) void
        +play(int amount) void
        +printStatus() void
    }
    class Mammal {
        <<abstract>>
    }
    class Bird {
        <<abstract>>
    }
    class Reptile {
        <<abstract>>
    }

    %% 구체적인 동물 클래스
    class Dog { +makeSound() void }
    class Lion { +makeSound() void }
    class Elephant { +makeSound() void }
    class Eagle { +makeSound() void }
    class Penguin { +makeSound() void }
    class Snake { +makeSound() void }

    %% 관리 및 비즈니스 로직 클래스
    class ZooKeeper {
        -String name
        -String specialty
        +ZooKeeper(String name, String specialty)
        +playWith(Animal animal) void
    }
    
    class Zoo {
        -ArrayList~Animal~ animals
        -ZooKeeper currentKeeper
        +setZooKeeper(ZooKeeper keeper) void
        +addAnimal(Animal animal) void
        +showAllAnimals() boolean
        +interactWithAnimal(int index) void
        +feedAnimal(int index, Food food) void
        +useSpecialAbility(int index) void
        +printStatistics() void
        +getAnimalCount() int
    }
    
    class Main {
        +main(String[] args) void
    }

    %% 상속 관계 (Inheritance)
    Animal <|-- Mammal
    Animal <|-- Bird
    Animal <|-- Reptile
    
    Mammal <|-- Dog
    Mammal <|-- Lion
    Mammal <|-- Elephant
    
    Bird <|-- Eagle
    Bird <|-- Penguin
    
    Reptile <|-- Snake

    %% 구현 관계 (Realization)
    Flyable <|.. Eagle
    Swimmable <|.. Penguin
    Sprayable <|.. Elephant

    %% 연관/의존 관계 (Association/Dependency)
    Zoo o-- Animal : contains
    Zoo o-- ZooKeeper : has
    Animal ..> Food : consumes
    Main ..> Zoo : uses
