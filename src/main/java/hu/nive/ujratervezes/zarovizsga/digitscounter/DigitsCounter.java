package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        Set<Character> result = new HashSet<>();
        char[] digits = s.toCharArray();
        for (char item : digits) {
            if (Character.isDigit(item)) {
                result.add(item);
            }
        }
        return result.size();
    }

}

