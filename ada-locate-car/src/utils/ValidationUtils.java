package utils;

public class ValidationUtils {

    public static void validadeIsNull(Object object, String isNullMsg, String isNotNullMsg) {
        if(object == null) {
            System.out.println(isNullMsg);
        } else {
            System.out.println(isNotNullMsg);
        }
    }
}
