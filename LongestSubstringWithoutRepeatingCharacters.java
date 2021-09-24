import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet();
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                int currSize = chars.size();
                chars.add(s.charAt(j));
                if (chars.size() == currSize) {
                    longestLength = Math.max(longestLength, currSize);
                    break;
                }
            }
            longestLength = Math.max(longestLength, chars.size());
            chars = new HashSet();
        }
        return longestLength;
    }

    @Test
    public void test() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, lengthOfLongestSubstring(" "));
        assertEquals(0, lengthOfLongestSubstring(""));
    }
}
