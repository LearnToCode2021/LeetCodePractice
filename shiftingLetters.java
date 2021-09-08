import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class shiftingLetters {

    /** First pass at solution, time complexity is too slow: O(n^2)? */
    public String solution(String s, int[] shifts) {
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

//    public String solution(String s, int[] shifts) {
//        //map with keys = integer position in String s, and values = int ranging from 0 to 25, representing
//        // a - z. Need to add 97 to value later to get corresponding ASCII character.
//        Map<Integer, Character> returnCharInts= new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            for (int k = 0; k <= i; k++) {
//                if (! returnCharInts.containsKey(k)) {
//                    returnCharInts.put(k, s.charAt(k) - 97 + )
//                }
//            }
//        }
//    }

    @Test
    public void test() {
        assertEquals("rpl", solution("abc", new int[] {3, 5, 9}));
        assertEquals("gfd", solution("aaa", new int[] {1, 2, 3}));
    }
}
