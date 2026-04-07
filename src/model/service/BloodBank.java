package service;

import model.Donor;
import model.Receiver;
import exception.PersonNotFoundException;
import exception.InsufficientBloodStockException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BloodBank {
    private ArrayList<Donor> donors;
    private ArrayList<Receiver> receivers;
    private HashMap<String, Integer> bloodStock;

    public BloodBank() {
        donors = new ArrayList<>();
        receivers = new ArrayList<>();
        bloodStock = new HashMap<>();

        bloodStock.put("A+", 0);
        bloodStock.put("A-", 0);
        bloodStock.put("B+", 0);
        bloodStock.put("B-", 0);
        bloodStock.put("AB+", 0);
        bloodStock.put("AB-", 0);
        bloodStock.put("O+", 0);
        bloodStock.put("O-", 0);
    }

    public void addDonor(Donor donor) {
        donors.add(donor);
        int currentUnits = bloodStock.get(donor.getBloodGroup());
        bloodStock.put(donor.getBloodGroup(), currentUnits + donor.getDonationUnits());
        System.out.println("Donor added successfully.");
    }

    public void addReceiver(Receiver receiver) {
        receivers.add(receiver);
        System.out.println("Receiver added successfully.");
    }

    public void viewAllDonors() {
        if (donors.isEmpty()) {
            System.out.println("No donors found.");
            return;
        }

        for (Donor donor : donors) {
            donor.showDetails();
            System.out.println();
        }
    }

    public void viewAllReceivers() {
        if (receivers.isEmpty()) {
            System.out.println("No receivers found.");
            return;
        }

        for (Receiver receiver : receivers) {
            receiver.showDetails();
            System.out.println();
        }
    }

    public void searchDonorByBloodGroup(String bloodGroup) {
        boolean found = false;

        for (Donor donor : donors) {
            if (donor.getBloodGroup().equalsIgnoreCase(bloodGroup)) {
                donor.showDetails();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No donor found for blood group: " + bloodGroup);
        }
    }

    public void searchReceiverById(int id) throws PersonNotFoundException {
        for (Receiver receiver : receivers) {
            if (receiver.getId() == id) {
                receiver.showDetails();
                return;
            }
        }
        throw new PersonNotFoundException("Receiver with ID " + id + " not found.");
    }

    public void issueBlood(String bloodGroup, int units) throws InsufficientBloodStockException {
        int availableUnits = bloodStock.getOrDefault(bloodGroup, 0);

        if (availableUnits < units) {
            throw new InsufficientBloodStockException("Not enough blood stock. Available units: " + availableUnits);
        }

        bloodStock.put(bloodGroup, availableUnits - units);
        System.out.println(units + " units of " + bloodGroup + " issued successfully.");
    }

    public void addBloodStock(String bloodGroup, int units) {
        int currentUnits = bloodStock.getOrDefault(bloodGroup, 0);
        bloodStock.put(bloodGroup, currentUnits + units);
        System.out.println("Blood stock updated successfully.");
    }

    public void viewBloodStock() {
        System.out.println("----- Blood Stock -----");
        for (Map.Entry<String, Integer> entry : bloodStock.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " units");
        }
    }
}