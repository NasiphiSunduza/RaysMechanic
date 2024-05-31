package za.ac.cput.util;

public class Helper {
    public static boolean isStringNull(String name) {
        if (name.isEmpty() || name == null) {
            return true;
        }

        return false;
    }


}