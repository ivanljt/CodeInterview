package leetcode.twopointer;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 *
 * 注意：只考虑字母数字 字符，忽略大小写
 */
class T125ValidPalindrome {

    class SolutionRecord {
        /**
         * 思路，比较首尾两个「合法」的字符，是否相等。
         * * 时间复杂度 O(N)
         * * 空间复杂度 O(1)
         */
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                while (!isAlphanumeric(ci) && i < s.length() - 1) {
                    ci = s.charAt(++i);
                }
                while (!isAlphanumeric(cj) && j > 0) {
                    cj = s.charAt(--j);
                }

                if (isAlphanumeric(ci) && isAlphanumeric(cj) && Character.toUpperCase(ci) != Character.toUpperCase(cj)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private boolean isAlphanumeric(char c) {
            return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
        }
    }

    /**
     * 「优雅一点的解法」。在一个循环里面的处理多件事情。
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     * */
    public boolean isPalindrome(String s) {
        if(s == null || s.length()== 0){
            return true;
        }
        int i = 0;
        int j = s.length()-1;
        char cHead;
        char cTail;
        while(i < j){
            cHead = s.charAt(i);
            cTail = s.charAt(j);
            if(!Character.isLetterOrDigit(cHead)){
                i++;
            }else if(!Character.isLetterOrDigit(cTail)){
                j--;
            }else{//满足条件了才进行转换
                if(Character.toUpperCase(cHead) != Character.toUpperCase(cTail)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
