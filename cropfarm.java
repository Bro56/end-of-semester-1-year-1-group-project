// Parent Class
class crop_farm {
    protected String nameofCrop;
    protected String cropType;
    protected double quantity_produced;

    public crop_farm(String nameofCrop, String cropType, double quantity) {
        this.nameofCrop = nameofCrop;
        this.cropType = cropType;
        this.quantity_produced = quantity;
    }

    public void displayDetails() {
        System.out.println("Crop Name: " + nameofCrop);
        System.out.println("Crop Type: " + cropType);
        System.out.println("Quantity Produced: " + quantity_produced);
    }
}

// Child Class 1 (For the first type of crop)
class farm1 extends crop_farm {
    public farm1(String nameofCrop, String cropType, double quantity) {
        super(nameofCrop, cropType, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Farm 1 (First Crop Type) ===");
        super.displayDetails();
    }
}

// Child Class 2 (For the second type of crop)
class farm2 extends crop_farm {
    public farm2(String nameofCrop, String cropType, double quantity) {
        super(nameofCrop, cropType, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Farm 2 (Second Crop Type) ===");
        super.displayDetails();
    }
}