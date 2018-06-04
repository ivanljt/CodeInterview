package t04二维数组中的查找;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
class FindInTwoDimensionalArray {
    /**
     * 思路：每次排除尽可能多的元素
     * 循环中，从右上角开始，如果target = 当前元素,return true
     * if target < 当前元素，排除「当前列」
     * if target > 当前元素，排序「当前行」
     *
     * 时间复杂度：O(min(raws,cols))
     * 空间：
     * */
    public boolean Find(int target, int[][] array) {
        int raw = array.length;
        int col = array[0].length;
        //从右上角开始，[0][col-1]
        //if >  raw+1
        int iRaw = 0;
        int iCol = col - 1;
        while (iRaw < raw && iCol >= 0) {
            int n = array[iRaw][iCol];
            if (target == n) {
                return true;
            } else if (target < n) {
                //列数 -1
                iCol--;
            } else {
                //行数 - 1
                iRaw++;
            }
        }
        return false;
    }
}
