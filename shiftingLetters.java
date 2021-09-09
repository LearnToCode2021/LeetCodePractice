import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class shiftingLetters {

    /** First pass at solution, time complexity is too slow: O(n^2)? */
    public String solutionSlow(String s, int[] shifts) {
        int[] returnCharInts = new int[shifts.length];
        for (int i = 0; i < s.length(); i++) {
            returnCharInts[i] = s.charAt(i);
        }
        for (int i = 0; i < shifts.length; i++) {
            for (int k = 0; k <= i; k++) {
                int valAtK = returnCharInts[k] - 97;
                valAtK += shifts[i];
                valAtK = valAtK % 26;
                valAtK += 97;
                returnCharInts[k] = valAtK;
            }
        }
        String retString = "";
        for (int i : returnCharInts) {
            retString += (char) i;
        }
        return retString;
    }

    public String solutionSlow2(String s, int[] shifts) {
        //map with keys = integer position in String s, and values = int ranging from 0 to 25, representing
        // a - z. Need to add 97 to value later to get corresponding ASCII character.
        Map<Integer, Integer> returnCharInts= new HashMap();
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k <= i; k++) {
                int val;
                if (! returnCharInts.containsKey(k)) {
                    val = s.charAt(k) - 97;
                } else {
                    val = returnCharInts.get(k);
                }
                val += shifts[i];
                val %= 26;
                returnCharInts.put(k, val);
            }
        }
        String retString = "";
        for (int i = 0; i < s.length(); i++) {
            retString += (char) (returnCharInts.get(i) + 97);
        }
        return retString;
    }

    public String solutionSlow3(String s, int[] shifts) {
        String retString = "";
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 97;
            for (int k = i; k < shifts.length; k++) {
                val += shifts[k];
                val %= 26;
            }
            retString += (char) (val + 97);
        }
        return retString;
    }

//    public String solution(String s, int[] shifts) {
//        String retString = "";
//        for (int i = 0; i < s.length(); i++) {
//            int val = s.charAt(i) - 97;
//            IntStream st = Arrays.stream(shifts, i, shifts.length).mapToDouble()
//            int addVal = Arrays.stream(shifts, i, shifts.length).mapToInt(e -> e).sum();
//            val += addVal;
//            val %= 26;
//            retString += (char) (val + 97);
//        }
//        return retString;
//    }

    public String solution(String s, int[] shifts) {
        StringBuffer retString = new StringBuffer(s);
        int addVal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 97;
            addVal += shifts[i] % 26;
            val += addVal;
            val %= 26;
            retString.setCharAt(i, (char) (val + 97));
        }
        return retString.toString();
    }

    @Test
    public void test() {
        assertEquals("rpl", solution("abc", new int[] {3, 5, 9}));
        assertEquals("gfd", solution("aaa", new int[] {1, 2, 3}));
        assertEquals("wqqwlcjnkphhsyvrkdod", solution("mkgfzkkuxownxvfvxasy",
                new int[] {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}
        ));
    }
}
