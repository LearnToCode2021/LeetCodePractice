import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Stack;


public class maxTurbulenceSize {

    public int solution(int[] arr) {
        int less = 1;
        int greater = 1;
        int result = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                less = greater + 1;
                greater = 1;
                result = Math.max(result, less);
            }
            else if (arr[i] > arr[i + 1]) {
                greater = less + 1;
                less = 1;
                result = Math.max(result, greater);
            }
            else {
                greater = 1;
                less = 1;
            }
        }
        return result;

//    public int solution(int[] arr) {
//        int largestTurbulenceSize = 1;
//        for (int i = 0; i < arr.length; i++) {
//            int less = helper(i, true, arr);
//            int greater = helper(i, false, arr);
//            largestTurbulenceSize = Math.max(largestTurbulenceSize, Math.max(less, greater));
//        }
//        return largestTurbulenceSize;
//    }
//
//    public int helper(int prev, boolean compareLessThan, int[] arr) {
//        if (prev >= arr.length - 1) {
//            return 1;
//        }
//        else if (compareLessThan) {
//            if (arr[prev] < arr[prev + 1]) {
//                return 1 + helper(prev + 1, false, arr);
//            }
//            else { return 1; }
//        }
//        else {
//            if (arr[prev] > arr[prev + 1]) {
//                return 1 + helper(prev + 1, true, arr);
//            }
//            else { return 1; }
//        }
    }

    @Test
    public void test() {
        assertEquals(5, solution(new int[] {9,4,2,10,7,8,8,1,9}));
        assertEquals(2, solution(new int[] {4,8,12,16}));
        assertEquals(1, solution(new int[] {100}));
        assertEquals(8, solution(new int[] {0,8,45,88,48,68,28,55,17,24}));
    }
}