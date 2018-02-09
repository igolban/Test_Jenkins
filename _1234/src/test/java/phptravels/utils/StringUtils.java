package phptravels.utils;

import java.util.UUID;

public class StringUtils {
    public static String getRandomEmailAddress() {
        return UUID.randomUUID().toString().substring(0, 15) + "@mailnesia.com";


    }
}
