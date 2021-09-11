import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public class Tree {
        int value;
        ArrayList<Tree> branches;

        public Tree(int val) {
            this.value = val;
            this.branches = new ArrayList<>();
        }

        public Tree(int val, ArrayList<Tree> b) {
            this.value = val;
            this.branches = b;
        }

        public boolean isLeaf() {
            return this.branches.isEmpty();
        }

        public void addBranch(Tree toAdd) {
            this.branches.add(toAdd);
        }

        public void setValue(int val) {
            this.value = val;
        }
    }

    public int solution(int[] nums) {
        Tree solutionTree = new Tree();
        for (int start = 0; start < nums.length - 2; start++) {
            for (int subseq = start + 1; subseq < nums.length; subseq++) {

            }
        }
    }



    @Test
    public void test() {
        assertEquals(7, solution(new int[] {2, 4, 6, 8, 10}));
        assertEquals(16, )
    }
}
