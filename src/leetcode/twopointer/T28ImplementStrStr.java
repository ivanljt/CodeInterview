package leetcode.twopointer;

/**
 * 实现 String#indexOf
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
class T28ImplementStrStr {

    /**
     * i 指向 haystack
     * j 指向 needle，同时也是 i + j 表示 当前匹配到的 haystack 中的字符。
     * <p>
     * * 时间复杂度 O(M*N)
     * * 空间复杂度 O(1)
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; /*i < haystack.length()*/ ; i++) {//注意这里不需要判断，内循环已经做了判断
            for (int j = 0; ; j++) {
                if (j == needle.length()) {//匹配到了尾部
                    return i;
                }
                if (i + j == haystack.length()) {//已经被匹配完了，长度不够
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {//以 i 开始的子串不匹配
                    break;
                }
            }
        }
    }

    class SolutionRecord {
        //注意特殊情况 "aaa"  "aaaa"; a a
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) {
                return 0;
            }
            int nIndex = 0;

            for (int i = 0; i < haystack.length(); i++) {
                int index = i;
                while (index < haystack.length()
                        && nIndex < needle.length()
                        && needle.charAt(nIndex) == haystack.charAt(index)) {
                    index++;
                    nIndex++;
                    if (nIndex == needle.length() && index < haystack.length()) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
