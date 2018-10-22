package examination;

/**
 * 翻转字符串，但是要保持原来位置的大小写。
 * 比如 AbcDe >>  EdcBa
 */
class ReverseStringWithCase {
    void reverse(char[] ary) {
        if (ary == null || ary.length == 0) {
            return;
        }
        int i = 0;
        int j = ary.length - 1;
        while (i < j) {
            char ci = ary[i];
            char cj = ary[j];
            ary[i] = Character.isUpperCase(ci) ? Character.toUpperCase(cj) : Character.toLowerCase(cj);//保持原来的大小写状态
            ary[j] = Character.isUpperCase(cj) ? Character.toUpperCase(ci) : Character.toLowerCase(ci);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] ary = "AbcDe".toCharArray();
        ReverseStringWithCase reverseStringWithCase = new ReverseStringWithCase();
        reverseStringWithCase.reverse(ary);
        System.out.println(ary);
    }
}
