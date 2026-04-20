package main;

import model.Donor;
import model.Receiver;
import service.BloodBank;
import util.InputUtil;
import exception.InvalidBloodGroupException;
import exception.InsufficientBloodStockException;
import exception.PersonNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BloodBank bloodBank = new BloodBank();

        while (true) {
            System.out.println("\n========== Blood Bank Management System ==========");
            System.out.println("1. Add Donor");
            System.out.println("2. Add Receiver");
            System.out.println("3. View All Donors");
            System.out.println("4. View All Receivers");
            System.out.println("5. Search Donor by Blood Group");
            System.out.println("6. View Blood Stock");
            System.out.println("7. Issue Blood");
            System.out.println("8. Add Blood Stock");
            System.out.println("9. Search Receiver by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Donor ID: ");
                        int donorId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String donorName = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int donorAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Blood Group: ");
                        String donorBloodGroup = sc.nextLine().toUpperCase();
                        InputUtil.validateBloodGroup(donorBloodGroup);

                        System.out.print("Enter Phone: ");
                        String donorPhone = sc.nextLine();

                        System.out.print("Enter Donation Units: ");
                        int donationUnits = sc.nextInt();
                        sc.nextLine();

                        Donor donor = new Donor(donorId, donorName, donorAge, donorBloodGroup, donorPhone,
                                donationUnits);
                        bloodBank.addDonor(donor);
                        break;

                    case 2:
                        System.out.print("Enter Receiver ID: ");
                        int receiverId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String receiverName = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int receiverAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Blood Group: ");
                        String receiverBloodGroup = sc.nextLine().toUpperCase();
                        InputUtil.validateBloodGroup(receiverBloodGroup);

                        System.out.print("Enter Phone: ");
                        String receiverPhone = sc.nextLine();

                        System.out.print("Enter Required Units: ");
                        int requiredUnits = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Disease: ");
                        String disease = sc.nextLine();

                        Receiver receiver = new Receiver(receiverId, receiverName, receiverAge, receiverBloodGroup,
                                receiverPhone, requiredUnits, disease);
                        bloodBank.addReceiver(receiver);
                        break;

                    case 3:
                        bloodBank.viewAllDonors();
                        break;

                    case 4:
                        bloodBank.viewAllReceivers();
                        break;

                    case 5:
                        System.out.print("Enter Blood Group to Search: ");
                        String searchGroup = sc.nextLine().toUpperCase();
                        InputUtil.validateBloodGroup(searchGroup);
                        bloodBank.searchDonorByBloodGroup(searchGroup);
                        break;
                    case 6:
                        bloodBank.viewBloodStock();
                        break;
                    case 7:
                        System.out.print("Enter Receiver ID: ");
                        int recId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Blood Group to Issue: ");
                        String issueGroup = sc.nextLine().toUpperCase();
                        InputUtil.validateBloodGroup(issueGroup);

                        System.out.print("Enter Units to Issue: ");
                        int issueUnits = sc.nextInt();
                        sc.nextLine();

                        bloodBank.issueBloodToReceiver(recId, issueGroup, issueUnits);
                        break;
                    case 8:
                        System.out.print("Enter Blood Group: ");
                        String stockGroup = sc.nextLine().toUpperCase();
                        InputUtil.validateBloodGroup(stockGroup);

                        System.out.print("Enter Units to Add: ");
                        int stockUnits = sc.nextInt();
                        sc.nextLine();

                        bloodBank.addBloodStock(stockGroup, stockUnits);
                        break;

                    case 9:
                        System.out.print("Enter Receiver ID: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();

                        bloodBank.searchReceiverById(searchId);
                        break;

                    case 0:
                        System.out.println("Thank you for using Blood Bank Management System.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter proper numeric value.");
                sc.nextLine();
            } catch (InvalidBloodGroupException | InsufficientBloodStockException | PersonNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}