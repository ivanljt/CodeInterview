package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 思路：使用 map 记录字符出现的下标，
     * start 作为左边界，max 记录当前的「最长不重复的字符子串的长度」
     * 左边界为上次出现位置以及 当前leftBound 中的大者。
     **/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;//左边界
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);//当前下标对应的字符
            start = Math.max(start, map.containsKey(ch) ? map.get(ch) + 1 : 0);//前面一个重复字符对应的下标 +1
            max = Math.max(max, i - start + 1);//计算不重复子串长度，根据情况更新
            map.put(ch, i);//存储下标
        }
        return max;
    }
}

class ImplHistory {
    class Solution {
        //分析。这道题只是求长度，而不用内容.如果需要拿到子串的内容可以用两个下标把范围记录下来
        //「滑动窗口」 [i,j]
        //如果遇到的重复的字符，那就把 i 到 i+？ 范围内的内容「删除掉」，
        //问题变为，如何知道重复了没有呢？

//     public int lengthOfLongestSubstring(String s) {
//         int[] cs = new int[256];
//         int i = 0;
//         for(int j = 0; j < s.length();j++){
//             if(cs[s.charAt[j]] != 0){//说明重复了？

//             }
//         }
//     }

        // public int lengthOfLongestSubstring(String s) {
        //     if(s == null || s.length() == 0){
        //         return 0;
        //     }
        //     int i = 0;
        //     int j = 0;
        //     int len = s.length();
        //     Set<Character> set = new HashSet<>();
        //     int max = 0;
        //     // [i,j]
        //     while(i < len && j < len){
        //         if(set.contains(s.charAt(j))){
        //             set.remove(s.charAt(i++));//移除滑动窗口的左边的元素，一直到右边的待添加元素与其中的元素没有重复为止
        //         }else{
        //             set.add(s.charAt(j++));
        //             max = Math.max(j-i,max);
        //         }
        //     }
        //     return max;
        // }
        //使用 hashmap
        public int lengthOfLongestSubstring0(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int i = 0;
            int max = 0;
            int[] map = new int[128];//基础数据类型数组，即使是局部变量也会初始化为默认值； map 记录出现下标的下一个位置
            for (int k = 0; k < 128; k++) {//因为 int 数组类型默认初始化为 0，而数组的下标可能为 0，所以这里可以初始化为-1。
                map[k] = -1;
            }
            //[i,j]
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map[c] != -1) {
                    i = Math.max(map[c] + 1, i);//出现过的地方，如果在窗口的左侧，则不需要更新窗口的左边界
                }
                max = Math.max(max, j - i + 1);
                map[c] = j;//记录下标，j 可能为 0 呀，所以示例里面是把它置为 j+1；也就是实际下标的下一个位置
            }
            return max;
        }

        //考虑到每次更新滑动窗口的左下标时，都是使用 map[c] + 1，我们在记录的时候，可以直接记录当前位置的下一个位置，这么做的话，可以不用为了数组下标可能为 0，而去手动初始化 map 数组的值为 1
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int i = 0;
            int max = 0;
            int[] map = new int[128];//基础数据类型数组，即使是局部变量也会初始化为默认值； map 记录出现下标的下一个位置
            //[i,j]
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map[c] != 0) {
                    i = Math.max(map[c], i);//出现过的地方，如果在窗口的左侧，则不需要更新窗口的左边界
                }
                max = Math.max(max, j - i + 1);
                map[c] = j + 1;//记录下标，j 可能为 0 呀，所以示例里面是把它置为 j+1；也就是实际下标的下一个位置
            }
            return max;
        }
    }
}
