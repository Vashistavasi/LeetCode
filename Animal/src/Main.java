class Animal {
    public void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat(); // static binding to Animal.eat() at compile time
    }
}