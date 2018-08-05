package t50_01_FirstNotRepeatingChar;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
class FirstNotRepeatingChar {


    /**
     * 思路：先遍历一次数组，记录元素出现次数。
     * 再遍历数组，如果当前字符出现次数为1，返回它的下标。否则继续，一直到数组结束为止。
     * * 时间复杂度 O(N) 最坏情况下，需要两次完整遍历
     * * 空间复杂度 O(N+32) = O(N)  将字符串转换为数组
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] ary = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();//这里用数组来存储也是可以的。不过差别不大。
        for (int i = 0; i < ary.length; i++) {
            char c = ary[i];
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }
        //因为要找到「第一个」只出现一次的数组，所以需要从头遍历数组。
        for (int i = 0; i < ary.length; i++) {
            char c = ary[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
