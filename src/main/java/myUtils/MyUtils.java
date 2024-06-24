package myUtils;

import java.util.Arrays;
import java.util.List;

public class MyUtils {
    public static List<String> getValFromToken(String token) {
        token = token.replace("(", "").replace(")", "");
        return Arrays.asList(token.split(","));
    }

}