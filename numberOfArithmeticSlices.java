import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Given an integer array nums, return the number of all the arithmetic subsequences of nums.

 A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

 For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 The test cases are generated so that the answer fits in 32-bit integer.

 */
public class numberOfArithmeticSlices {
    int numValidSubseqs = 0;
    public void helper(List<Integer> subseq, int[] A, int start) {
        if (start == A.length) {
            if (subseq.size() < 3) {
                return;
            }
            int diff = subseq.get(1) - subseq.get(0);
            for (int i = 1; i < subseq.size() - 1; i++) {
                if (subseq.get(i + 1) - subseq.get(i) != diff) {
                    return;
                }
            }
            numValidSubseqs += 1;
            return;
        }
        helper(subseq, A, start + 1);
        subseq.add(0, A[start]);
        helper(subseq, A, start + 1);
    }

    public int solution(int[] A) {
        List<Integer> subseq = new ArrayList<>();
        helper(subseq, A, 0);
        return numValidSubseqs;
    }



    @Test
    public void test() {
        assertEquals(7, solution(new int[] {2, 4, 6, 8, 10}));
        assertEquals(16, solution(new int[] {5, 5, 5, 5, 5}));
    }
}
