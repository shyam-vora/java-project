package util;

import exception.InvalidBloodGroupException;

public class InputUtil {

    public static boolean isValidBloodGroup(String bloodGroup) {
        String[] validGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for (String group : validGroups) {
            if (group.equalsIgnoreCase(bloodGroup)) {
                return true;
            }
        }
        return false;
    }

    public static void validateBloodGroup(String bloodGroup) throws InvalidBloodGroupException {
        if (!isValidBloodGroup(bloodGroup)) {
            throw new InvalidBloodGroupException("Invalid blood group! Please enter a valid group.");
        }
    }
}