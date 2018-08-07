package t50_2字符流中第一个不重复的字符;

/**
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 */
class FirstNotRepeatingCharInStream {

    //不需要一个额外的 StringBuilder 或者其他容器存储。一个长度为256的数组搞定。
    private int[] mOccurrence = new int[256];//下标为字符，值为**出现的位置对应的下标**，没有出现过的值 =1，出现>1次的，=-2
    private int mIndex = 0;//记录下标

    public FirstNotRepeatingCharInStream() {
        for (int i = 0; i < mOccurrence.length; i++) {
            mOccurrence[i] = -1;
        }
    }

    public void Insert(char ch) {
        if (ch > 255) {
            throw new RuntimeException("非法参数");
        }
        if (mOccurrence[ch] == -1) {//第一次出现。
            mOccurrence[ch] = mIndex;//记录下标。最小为0
        } else {
            mOccurrence[ch] = -2;
        }
        mIndex++;
    }

    //return the first appearance once char in current stringstream
    public char FirstAppearingOnce(String data) {
        if (data == null) {
            throw new IllegalArgumentException(data);
        }
        for (int i = 0; i < data.length(); i++) {
            Insert(data.charAt(i));
        }
        char ch = '#';//字符
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < mOccurrence.length; i++) {//从头到尾遍历容器数组。找出最早出现的数字。
            if (mOccurrence[i] >= 0 && mOccurrence[i] < minIndex) {//只出现了一次
                minIndex = mOccurrence[i];
                ch = (char) i;//「数组下标」对应的值。也就是「出现了一次的值」
            }
        }
        return ch;
        //错误的解法。minIndex 是第一个只出现一次的字符出现的下标，我们的目标是找到对应的 「字符」，可以用数组的下标强制 转换回来。。
//        return minIndex == Integer.MAX_VALUE ? '#' : (char)minIndex;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("")); // '\0'
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("g")); // 'g'
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("go")); // 'g'
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("goo")); // 'g'
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("goog")); // '\0'
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("googl")); // l
        System.out.println(new FirstNotRepeatingCharInStream().FirstAppearingOnce("googlea0")); // l
    }
}

class Sol2 {
    private int[] table = new int[256];
    //利用一个动态的数组记录插入的顺序，才能得到最先的顺序。StringBuilder 或者 容器都可以
    private StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        table[ch]++;
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {//按照字符输入顺序遍历数组。
            if (table[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }
}


