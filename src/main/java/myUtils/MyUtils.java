package myUtils;

import java.util.Arrays;
import java.util.List;

public class MyUtils {
    //questo metodo si occuperà solo di stringhe es:(3.2,4.6), perchè per le altre, es:(4.3) basta usare il replace
    public static List<String> getValFromToken(String token) {
        token = token.replace("(", "").replace(")", "");
        return Arrays.asList(token.split(","));
    }

}