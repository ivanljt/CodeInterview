package t八大排序;

import java.util.Random;

/**
 * 数据生产类
 */
public class DataFactory {

    public static int[] getRandomAry(int len) {
        return getRandomAry(len, len);
    }

    public static int[] getRandomAry(int len, int range) {
        Random random = new Random(System.currentTimeMillis());
        int[] ary = new int[len];
        for (int i = 0; i < len; i++) {
            ary[i] = random.nextInt(range);
        }
        return ary;
    }
}
