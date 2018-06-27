package t动手实现LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * 设计一个 LRU cache 数据结构。支持 get 和 set 操作。
 * get(key) - 获取 key 对应的 value。如果对应的值不存在的话，返回 -1
 * set(key,value) -  有则更新，无则插入。如果达到了最大容量，需要在插入之前先移除值。
 * <p>
 * ref: https://crossoverjie.top/2018/04/07/algorithm/LRU-cache/
 */
class LRUCache<K, V> {
    /**
     * 借助 LinkedHashMap 实现，要注意构造函数的参数，以及实现 removeEldestEntry 方法。
     */
    private LinkedHashMap<K, V> mLinkedHashMap;
    private int mCacheSize;

    public LRUCache(int cacheSize) {
        mCacheSize = cacheSize;
        mLinkedHashMap = new LinkedHashMap<K, V>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {//移除掉旧的 Entry,之所以 +1 是因为，插入元素之后才调用该方法。
                return mLinkedHashMap.size() == (mCacheSize + 1);
            }
        };
    }

    public void set(K k, V value) {
        mLinkedHashMap.put(k, value);
    }

    public V get(K k) {
        return mLinkedHashMap.get(k);
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(1);
        lruCache.set("aa", "aa");
        lruCache.set("bb", "bb");// bb put 进去之后，「mLinkedHashMap.size() == (mCacheSize + 1)」，触发移除
        System.out.println(lruCache.get("aa"));
        System.out.println(lruCache.get("bb"));
    }
}
// TODO: 2018/6/27 自己实现 LRUCache 逻辑
