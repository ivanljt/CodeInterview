package 剑指offer.t05替换空格;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        /**
         * 计算总的空格数。得出拓展后的长度。
         * 记得的思路：从后往前遍历。可以避免每次移动太多的字符，也就是一个字符串，如果需要移动的话，只需要移动一次
         * 计算空格数。
         * 得出最终的长度。扩容 ensureCap
         *
         * 时间 O(N)
         * 空间 O()
         *
         * 做错的原因：已经扩容，不能调用 insert
         * */
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int oldLen = str.length();
        int newLen = oldLen + (count * 2);
        str.setLength(newLen);
        newLen--;
        oldLen--;
        while (oldLen >= 0 && newLen >= 0) {
            //insert 会触发扩容。我们已经 setLength 了，不能再扩容
            if (str.charAt(oldLen) == ' ') {
                str.setCharAt(newLen--, '0');
                str.setCharAt(newLen--, '2');
                str.setCharAt(newLen--, '%');
                oldLen--;
            } else {
                str.setCharAt(newLen, str.charAt(oldLen));
                newLen--;
                oldLen--;
            }
        }
        return str.toString();
    }
}