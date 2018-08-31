package 剑指offer.t13机器人的运动范围;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * 注意问题是「能够访问多少个格子」
 */
public class RobotMove {
    /**
     * 思路：能够上下左右移动。首先检查是否越界，是否访问过，以及是否当前位置对应的和是否符合要求.
     * 每一轮递归中，当前格子如果符合要求的话， 1  + 从左右上下四个的格子出发能够到达的格子总数
     * 递归栈可以视为：
     * 到达递归基的时候：return 0。
     * 递归调用栈依次出栈：1 + 1 + 1 + ... + 0
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] hasVisit = new boolean[rows][cols];//记录是否访问过，避免重复计算
        return movingCount(threshold, 0, 0, rows, cols, hasVisit);
    }

    int movingCount(int threshold, int row, int col, int rows, int cols, boolean[][] hasVisit) {
        //递归终止条件
        if (row >= rows || row < 0
                || col >= cols || col < 0
                || hasVisit[row][col]
                || !checkNum(col, row, threshold)) {//检查
            return 0;
        }
        hasVisit[row][col] = true;
        return 1 + movingCount(threshold, row - 1, col, rows, cols, hasVisit)//参数比较多，注意顺序，不要传错位置
                + movingCount(threshold, row + 1, col, rows, cols, hasVisit)
                + movingCount(threshold, row, col + 1, rows, cols, hasVisit)
                + movingCount(threshold, row, col - 1, rows, cols, hasVisit);
    }

    //位数的和
    boolean checkNum(int n1, int n2, int threshold) {
        //获取个位数，/10  %10
        return getBitSum(n1) + getBitSum(n2) <= threshold;
    }

    int getBitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;//去掉个位数
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        int count = robotMove.movingCount(10, 1, 100);
        System.out.println(count);
        assert count == 29;
    }
}

class History {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        return movingCount(rows, cols, 0, 0, matrix, threshold);
    }

    //起点，计数。阈值
    int movingCount(int rows, int cols, int row, int col, int[][] matrix, int threshold) {
        if (row < 0 || row >= rows
                || col >= cols || col < 0
                || matrix[row][col] == 1
                || !check(col, row, threshold)) {
            return 0;
        }
        matrix[row][col] = 1;
        return 1 + movingCount(rows, cols, row - 1, col, matrix, threshold)
                + movingCount(rows, cols, row + 1, col, matrix, threshold)
                + movingCount(rows, cols, row, col - 1, matrix, threshold)
                + movingCount(rows, cols, row, col + 1, matrix, threshold);
    }

    boolean check(int n1, int n2, int k) {
        return getCount(n1) + getCount(n2) <= k;
    }

    int getCount(int num) {
        int s = 0;
        while (num != 0) {
            s += (num % 10);
            num /= 10;
        }
        return s;
    }
}