import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreakAPalindrome {

    public String breakPalindrome1(String palindrome) {
        int pal_length = palindrome.length();
        if (pal_length == 1) return "";
        int ctr = 0;
        while (palindrome.charAt(ctr) == 'a' || (pal_length % 2 == 1 && ctr == pal_length / 2)) {
            if (ctr == pal_length - 1) break;
            ctr++;
        }
        StringBuilder s = new StringBuilder(palindrome);
        if (ctr == pal_length - 1 && s.charAt(ctr) == 'a') {
            s.setCharAt(ctr, 'b');
            return s.toString();
        } else {
            s.setCharAt(ctr, 'a');
            return s.toString();
        }
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        char[] letters = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (letters[i] != 'a') {
                letters[i] = 'a';
                return new String(letters);
            }
        }
        letters[palindrome.length() - 1] = 'b';
        return new String(letters);
    }

    @Test
    public void test() {
        assertEquals("aaccba", breakPalindrome("abccba"));
        assertEquals("", breakPalindrome("a"));
        assertEquals("ab", breakPalindrome("aa"));
        assertEquals("aacecar", breakPalindrome("racecar"));
    }
}
