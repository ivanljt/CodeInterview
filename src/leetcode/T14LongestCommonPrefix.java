package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
class T14LongestCommonPrefix {
    /**
     *
     * * 时间复杂度 O(strs.length * min(strs[i].length))
     * * 空间复杂度 O()
     * */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String p = strs[0];
        int index = 0;
        boolean flag = false;
        //避免越界。比较
        while (index < p.length()) {
            //比较 所有字符串在指定位置的 字符是否相同
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || p.charAt(index) != strs[i].charAt(index)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                index++;
            }
        }
        return p.substring(0, index);//[ )
    }
}
