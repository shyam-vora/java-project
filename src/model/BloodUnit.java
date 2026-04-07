package model;

public class BloodUnit {
    private String bloodGroup;
    private int units;

    public BloodUnit(String bloodGroup, int units) {
        this.bloodGroup = bloodGroup;
        this.units = units;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}