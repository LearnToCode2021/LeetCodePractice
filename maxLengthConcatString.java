import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class maxLengthConcatString {
//    public int maxLength(List<String> arr) {
//        int maxUniqueLetters = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            Set<Character> first = new HashSet<>();
//            Set<Character> concat;
//            String frontString = arr.get(i);
//            char[] frontStringCharArray = frontString.toCharArray();
//            for (Character c: frontStringCharArray) {
//                first.add(c);
//            }
//            if (first.size() != frontString.length()) { continue; } // if the subsequence itself contains duplicates, skip;
//            concat = new HashSet<>(first);
//            for (int k = i + 1; k < arr.size(); k++) {
//                String addString = arr.get(k);
//                char[] addStringArray = addString.toCharArray();
//                for (Character c: addStringArray) {
//                    concat.add(c);
//                }
//                if (concat.size() != first.size() + addString.length()) {
//                    concat = new HashSet<>(first);
//                    continue;
//                }
//                first = new HashSet<>(concat);
//                maxUniqueLetters = Math.max(maxUniqueLetters, concat.size());
//            }
//            maxUniqueLetters = Math.max(maxUniqueLetters, first.size());
//        }
//        return maxUniqueLetters;
//    }

    public int maxLength(List<String> arr) {
        List<String> uniqueStrings = new ArrayList<>();
        uniqueStrings.add("");
        for (String s : arr) {
            if (!isUnique(s)) continue;
            List<String> uniqueForThisString = new ArrayList<>();
            for (String x : uniqueStrings) {
                String addString = x + s;
                if (isUnique(addString)) uniqueForThisString.add(addString);
            }
            uniqueStrings.addAll(uniqueForThisString);
        }

        int retLength = uniqueStrings.get(0).length();
        for (String s : uniqueStrings) {
            retLength = Math.max(s.length(), retLength);
        }
        return retLength;
    }

    public boolean isUnique(String s) {
        if (s.length() > 26) {
            return false;
        }
        char[] lettersInString = new char[26];
        for (Character c : s.toCharArray()) {
            lettersInString[c - 'a'] += 1;
            if (lettersInString[c - 'a'] > 1) { return false; }
        }
        return true;
    }

    @Test
    public void test() {
        String[] s1 = new String[] {"un", "iq", "ue"};
        List<String> l1 = Arrays.asList(s1);
        assertEquals(4, maxLength(l1));

        String[] s2 = new String[] {"cha", "r", "act", "ers"};
        List<String> l2 = Arrays.asList(s2);
        assertEquals(6, maxLength(l2));

        List<String> l3 = new ArrayList<>();
        l3.add("abcdefghijklmnopqrstuvwxyz");
        assertEquals(26, maxLength(l3));

        String[] s4 = new String[] {"a", "b", "c", "d", "e"};
        List<String> l4 = Arrays.asList(s4);
        assertEquals(5, maxLength(l4));

        String[] s5 = new String[] {"a", "abc", "d", "de", "def"};
        List<String> l5 = Arrays.asList(s5);
        assertEquals(6, maxLength(l5));

    }
}
