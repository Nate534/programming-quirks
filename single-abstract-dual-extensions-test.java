interface AnimalInterface {
    void speak();
}

abstract class AbstractAnimal implements AnimalInterface {
    @Override
    public void speak() {
        System.out.println("Animal speaks, ");
    }
}

class CatExtension extends AbstractAnimal {
    @Override
    public void speak() {
        super.speak();
        System.out.println("Meow!");
    }
}

class DogExtension extends AbstractAnimal {
    @Override
    public void speak() {
        super.speak();
        System.out.println("Woof!");
    }
}

public class SingleAbstractDualExtensionsTest {
    public static void main(String[] args) {
        
        CatExtension cat = new CatExtension();
        DogExtension dog = new DogExtension();

        cat.speak();
        dog.speak();

        
    }
}