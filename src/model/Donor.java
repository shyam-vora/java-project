package model;

public class Donor extends Person {
    private int donationUnits;

    public Donor(int id, String name, int age, String bloodGroup, String phone, int donationUnits) {
        super(id, name, age, bloodGroup, phone);
        this.donationUnits = donationUnits;
    }

    public int getDonationUnits() {
        return donationUnits;
    }

    @Override
    public void showDetails() {
        System.out.println("----- Donor Details -----");
        super.showDetails();
        System.out.println("Donation Units : " + donationUnits);
    }
}