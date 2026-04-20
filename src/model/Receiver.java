package model;

public class Receiver extends Person {
    private int requiredUnits;
    private String disease;
    public Receiver(int id, String name, int age, String bloodGroup, String phone, int requiredUnits, String disease) {
        super(id, name, age, bloodGroup, phone);
        this.requiredUnits = requiredUnits;
        this.disease = disease;
    }

    public int getRequiredUnits() {
        return requiredUnits;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void showDetails() {
        System.out.println("----- Receiver Details -----");
        super.showDetails();
        System.out.println("Required Units : " + requiredUnits);
        System.out.println("Disease        : " + disease);
    }
}