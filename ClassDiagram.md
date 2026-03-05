classDiagram
    class Animal {
        <<abstract>>
        -String name
        -int age
        -int hunger
        -int happiness
        +Animal(String name, int age)
        +eat() void
        +play() void
        +makeSound()* void
        +printStatus() void
        +getName() String
        +getAge() int
    }
    
    class Dog {
        +Dog(String name, int age)
        +makeSound() void
    }
    
    class Cat {
        +Cat(String name, int age)
        +makeSound() void
    }
    
    class Zoo {
        -ArrayList~Animal~ animals
        +addAnimal(Animal animal) void
        +showAllAnimals() boolean
        +feedAnimal(int index) void
        +playWithAnimal(int index) void
        +showAnimalStatus(int index) void
        +makeAnimalSound(int index) void
        +getAnimalCount() int
    }
    
    class Main {
        +main(String[] args) void
    }

    Animal <|-- Dog : 상속 (Inheritance)
    Animal <|-- Cat : 상속 (Inheritance)
    Zoo o-- Animal : 집합 (Aggregation)
    Main ..> Zoo : 의존 (Dependency)
