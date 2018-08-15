package other;

import java.util.ArrayList;
import java.util.List;


class FindSubSequentFromA2B {
    /**
     * 思路：遍历字符串，找出 a,b 的出现的下标，分别存储到 aIndexList 和 bIndexList 中
     * 遍历 aIndexList，bIndexList，
     * if(aIndex < bIndex) 通过 String#subString 获取子串，
     * 如果 result 中未包含该子串，则将它添加进来。
     *
     * <p>
     * * 时间复杂度 O(N^2) 「 N + (N/2)^2」
     * * 空间复杂度 O(N)
     */
    List<String> findSubSeq(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        List<Integer> aIndexList = new ArrayList<>();//存储对应位置的下标
        List<Integer> bIndexList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                aIndexList.add(i);
            } else if (ch == 'b') {
                bIndexList.add(i);
            }
        }
        for (int aIndex : aIndexList) {
            for (int bIndex : bIndexList) {
                if (aIndex < bIndex) {
                    String subSeq = str.substring(aIndex, bIndex+1);//左闭右开 [, )
                    if (!result.contains(subSeq)) {
                        result.add(subSeq);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 更优解法
     * */
    public static void main(String[] args) {
        List<String> strings = new FindSubSequentFromA2B().findSubSeq("fafabbbbbab");
        System.out.println(strings);
    }
}
