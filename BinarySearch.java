//LeetCode 704 Binary Search 9/23/21

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int upper = nums.length - 1;
        int lower = 0;
        int index;
        while (lower <= upper) {
            index = (lower + upper) / 2;
            int numAtIndex = nums[index];
            if (numAtIndex == target) { return index; }
            if (numAtIndex > target) {
                upper = index - 1;
            } else {
                lower = index + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(1, search(new int[] {0, 1, 2}, 1));
        assertEquals(1, search(new int[] {0, 1, 2, 3}, 1));
        assertEquals(-1, search(new int[] {0, 1, 2}, 69));
    }
}
