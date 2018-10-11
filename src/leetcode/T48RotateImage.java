package leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * */
class T48RotateImage {
    /**
     * 首先交换行
     * 然后，对称交换
     * 顺时针交换。
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * * 时间复杂度 O(N^2)
     * * 空间复杂度 O(1)
     *------------------------
     * 如果是逆时针交换。先交换列，然后对称交换
     *  * anticlockwise rotate
     *  * first reverse left to right, then swap the symmetry
     *  * 1 2 3     3 2 1     3 6 9
     *  * 4 5 6  => 6 5 4  => 2 5 8
     *  * 7 8 9     9 8 7     1 4 7
     */
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {//注意，不取「=」 号
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {//易错点。对称阵。只要交换 对角线两侧 的
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
