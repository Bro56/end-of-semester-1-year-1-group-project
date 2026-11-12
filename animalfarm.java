abstract class Animal_Farm {
    String nameofAnimal;
    String breed;
    String outputType;
    double quantity;

    public Animal_Farm(String nameofAnimal, String breed, String outputType, double quantity) {
        this.nameofAnimal = nameofAnimal;
        this.breed = breed;
        this.outputType = outputType;
        this.quantity = quantity;
    }

    abstract public void product();
}

class CowFarm extends Animal_Farm {
    public CowFarm(String breed, double quantity) {
        super("Cow", breed, "Milk/Meat", quantity);
    }

    @Override
    public void product() {
        System.out.println("Cow Farm (" + breed + ") produced " + quantity + " units of " + outputType + ".");
    }
}

class GoatFarm extends Animal_Farm {
    public GoatFarm(String breed, double quantity) {
        super("Goat", breed, "Milk/Meat", quantity);
    }

    @Override
    public void product() {
        System.out.println("Goat Farm (" + breed + ") produced " + quantity + " units of " + outputType + ".");
    }
}

class ChickenFarm extends Animal_Farm {
    public ChickenFarm(String breed, double quantity) {
        super("Chicken", breed, "Eggs/Meat", quantity);
    }

    @Override
    public void product() {
        System.out.println("Chicken Farm (" + breed + ") produced " + quantity + " units of " + outputType + ".");
    }
}