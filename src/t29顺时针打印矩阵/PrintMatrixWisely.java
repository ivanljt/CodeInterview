package t29顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */
class PrintMatrixWisely {
    /**
     * 思路：先确定打印的总圈数，为什么要这么做？找规律分析得出的。（通过圈数作为循环终止的判断依据，打印的起点位于 对角线上，x == y）
     * 在内部循环调用 顺时针打印函数.
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null) {
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        //打印的圈数。 (min(行数,列数)+1) / 2
        int circleCount = (Math.min(rows, cols) + 1) / 2;
        int start = 0;
        while (start < circleCount) {
            //根据圈数调整 i j
            printWisely(matrix, start, rows - start - 1,
                    start, cols - start - 1, list);
            start++;
        }
        return list;
    }

    //该函数只负责按照圈进行打印
    //----
    //|  |
    //----
    //特别注意，只有单行或者 单列的情况！
    void printWisely(int[][] matrix, int startRow, int endRow,
                     int startCol, int endCol, ArrayList<Integer> list) {
        for (int i = startCol; i <= endCol; i++) {
            list.add(matrix[startRow][i]);
        }
        for (int i = startRow + 1; i < endRow; i++) {
            list.add(matrix[i][endCol]);
        }
        //右—>左
        if (startRow < endRow) {//避免单行的情况下重复打印
            for (int i = endCol; i >= startCol; i--) {//注意只有一行的情况
                list.add(matrix[endRow][i]);
            }
        }
        //下—>上
        if (startCol < endCol) {//避免单列的情况下重复打印
            for (int i = endRow - 1; i > startRow; i--) {//注意只有一列的情况
                list.add(matrix[i][startCol]);
            }
        }
    }
}
