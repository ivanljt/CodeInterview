package 剑指offer.t58翻转单词序列;

/**
 * “student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”
 */
class ReverseSentence {

    /**
     * 思路: 先翻转整一个句子，然后翻转单词（以空格作为分界点）
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int len = str.length();
        char[] ary = str.toCharArray();
        //句子翻转
        reverse(ary, 0, len - 1);
        System.out.println(ary);
        //单词内部翻转
        for (int i = 0, start = 0; i < len; i++) {
            char c = ary[i];
            if (c == ' ') {
                reverse(ary, start, i - 1);
                start = i + 1;
            } else if (i == len - 1) {
                reverse(ary, start, i);
            }
        }
        System.out.println(ary);
        return new String(ary);
    }

    void reverse(char[] ary, int start, int end) {// [ ]
        //错误的代码。end  - i 。因为 i是从 start 开始的。 会导致前面的位置上的字符被替换
//        for (int i = start; i < (start + end) / 2; i++) {
//            char c = ary[i];
//            ary[i] = ary[end - i];
//            ary[end - i] = c;
//        }
        while (start < end) {
            char c = ary[start];
            ary[start] = ary[end];
            ary[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        assert " I am a student. ".equals(reverseSentence.ReverseSentence(" student. a am I "));
    }
}
