package 剑指offer.t48最长不包含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3
 * 请从字符串中找出一个最长的不包含重复字符串的子字符串，计算该最长子字符串的长度。假设字符串中只包含‘a’~‘z’的字符。
 * <p>
 * 例子：
 * 例如，在字符串“arabcacfr”中，最长的不含重复字符的子字符串是“acfr”，长度为4。
 */
class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 遍历过程中，把数据存储到一个 map 中，Key 为 Char，value 为 int（也就是出现的下标）
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Character c;
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            //if(map.containsKey(c)){//发现重复了
            left = Math.max(map.containsKey(c) ? map.get(c) + 1 : 0, left);//上一次出现的位置 + 1
            max = Math.max(max, i - left + 1);
            //}
            map.put(c, i);
        }
        return max;
    }
}
