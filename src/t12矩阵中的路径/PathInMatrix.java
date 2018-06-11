package t12矩阵中的路径;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子
 */
class PathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //回溯思想解决这种题目最好的方式是 将题意抽象出来
        //其实 之前的字符是什么并不重要，重要的是，当前的字符是否能够正常匹配。
        //如果能够正常匹配，则进入下一步。
        //如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
        boolean[] visited = new boolean[rows * cols];//记录是否已经访问过
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }

        for (int row = 0; row < rows; row++) {//可以从任意一个格子出发。
            for (int col = 0; col < cols; col++) {
                //visited[row*cols + col] = true;
                if (hasPath(matrix, visited, row, col,
                        rows, cols, str, 0)) {
                    return true;
                }
                //visited[row*cols + col] = false;
            }
        }
        return false;
    }

    boolean hasPath(char[] matrix, boolean[] visited, int row, int col,
                    int rows, int cols, char[] str, int curCharIndex) {
        if (curCharIndex == str.length) {//已经匹配到最后一个字符了
            return true;
        }
        boolean hasPath = false;
        int curMatrixIndex = row * cols + col;//矩阵下标与 当前匹配到的字符串中的下标不同。这里容易搞错
        if (row >= 0 && row < rows &&
                col < cols && col >= 0 &&
                matrix[curMatrixIndex] == str[curCharIndex] &&//当前字符匹配
                !visited[curMatrixIndex]) {
            curCharIndex++;
            visited[curMatrixIndex] = true;
            //为什么会有四个方向呢？因为可以从「任意一个格子」**开始**。后面的递归过程中，其实有一个方向是固定无效的
            hasPath = hasPath(matrix, visited, row - 1, col,
                    rows, cols, str, curCharIndex)
                    || hasPath(matrix, visited, row + 1, col,
                    rows, cols, str, curCharIndex)
                    || hasPath(matrix, visited, row, col - 1,
                    rows, cols, str, curCharIndex)
                    || hasPath(matrix, visited, row, col + 1,
                    rows, cols, str, curCharIndex);

            if (!hasPath) {
//                curCharIndex--;//局部变量，自减没有作用，回溯的情况下，每一层有自己的 index
                visited[curMatrixIndex] = false;//标记
            }
        }
        return hasPath;
    }
}
