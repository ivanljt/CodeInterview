package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class MapDemo {
    /**
     * HashMap 迭代无顺序
     * LinkedHashMap 默认按照访问的顺序进行迭代？
     * */
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            String text = "other" + i;
            linkedHashMap.put(text, i);
            hashMap.put(text, i);
        }
        for (Map.Entry<String, Integer> integerIntegerEntry : hashMap.entrySet()) {
            System.out.println("hashMap entry: " + integerIntegerEntry);
        }
        System.out.println("=====");
        for (Map.Entry<String, Integer> integerIntegerEntry : linkedHashMap.entrySet()) {
            System.out.println("linkedHashMap entry：" + integerIntegerEntry);
        }
    }
}
