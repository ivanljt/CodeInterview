package leetcode.backtracing;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * 相同的题
 *
 * @see 剑指offer.t12矩阵中的路径.PathInMatrix
 */
class T79WordSearch {

    /**
     * 思路：回溯法。以任意的格子作为起点，然后上下左右的检测是否匹配，
     * 当最后一个字符匹配完成时，说明存在对应的路径。
     * <p>
     * * 时间复杂度 O(M*N*word.length?)
     * * 空间复杂度 O()
     */
    public boolean exist(char[][] board, String word) {
        final int rows = board.length;
        final int cols = board[0].length;
        if (rows == 0 || cols == 0 || word == null) {
            return false;
        }
        boolean[][] hasVisit = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean exist = exist(board, i, j, word, 0, hasVisit);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归匹配
     */
    boolean exist(char[][] board, int row, int col, String word, int currentIndex, boolean[][] hasVisit) {
        if (currentIndex == word.length()) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean exist = false;
        if (row < rows && row >= 0 && col < cols && col >= 0
                && board[row][col] == word.charAt(currentIndex)
                && !hasVisit[row][col]) {
            hasVisit[row][col] = true;
            exist = exist(board, row - 1, col, word, currentIndex + 1, hasVisit)
                    || exist(board, row + 1, col, word, currentIndex + 1, hasVisit)
                    || exist(board, row, col - 1, word, currentIndex + 1, hasVisit)
                    || exist(board, row, col + 1, word, currentIndex + 1, hasVisit);
            if (!exist) {
                hasVisit[row][col] = false;
            }
        }
        return exist;
    }
}
