import org.junit.Test;
import org.junit.Assert.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpiralMatrix {

    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    /** For m x n matrix:
     *  # # # #     row = 0
     *  # # # #     row = 1
     *  # # # #     row = 2
     *  row number is represented by matrix[row].
     *  col number is represented by matrix[row][col];
     *  Col directions are left and right, Row directions are up and down
     *  Algorithm is to step col steps
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> retList = new LinkedList<>();
        Direction nextDir = Direction.RIGHT;
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        int row = 0; int col = 0;
        int rowSteps = maxRows - 1;
        int colSteps = maxCols;
        while(rowSteps >= 0 && colSteps >= 0) {
            switch (nextDir) {
                case RIGHT:
                    int ctr = 0;
                    while(ctr < colSteps) {
                        retList.add(matrix[row][col]);
                        col++;
                        ctr++;
                    }
                    col--; //decrement col counter to be in range

                    colSteps--;
                    row++; // next direction should not double count last int
                    nextDir = Direction.DOWN;
                    continue;

                case LEFT:
                    ctr = 0;
                    while (ctr < colSteps) {
                        retList.add(matrix[row][col]);
                        col--;
                        ctr++;
                    }
                    col++;

                    colSteps--;
                    row--; //next direction should not double count
                    nextDir = Direction.UP;
                    continue;

                case UP:
                    ctr = 0;
                    while (ctr < rowSteps) {
                        retList.add(matrix[row][col]);
                        row--;
                        ctr++;
                    }
                    row++;

                    col++; //next direction should not double count
                    rowSteps--;
                    nextDir = Direction.RIGHT;
                    continue;

                case DOWN:
                    ctr = 0;
                    while(ctr < rowSteps) {
                        retList.add(matrix[row][col]);
                        row++;
                        ctr++;
                    }
                    row--; //decrement row counter to be in range

                    rowSteps--;
                    col--; //next direction should not include last int
                    nextDir = Direction.LEFT;
                    continue;
            }
        }
        return retList;
    }

    @Test
    public void test() {
//        int[][] simpleTestMatrix = new int[][]{{1, 2, 3}};
//        List<Integer> simpleTestMatrixList = List.of(1, 2, 3);
//        assertEquals(simpleTestMatrixList, spiralOrder(simpleTestMatrix));
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> actual = spiralOrder(matrix);
        Integer[] matrixArray = new Integer[] {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
//        List<Integer> expected = List.of(1, 2, 3, 4, 8, 12, 11 ,10, 9, 5, 6, 7);
        List<Integer> expected = Arrays.asList(matrixArray);
        assertEquals(expected, actual);
    }
}
