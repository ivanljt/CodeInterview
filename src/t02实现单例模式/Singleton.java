package t02实现单例模式;

/**
 * 关键：变量是私有且静态
 * */
public class Singleton {

}

/**
 * 双重校验锁的实现方式
 * <p>
 * 其实称为「双重校验锁」不太好，容易让人误解——以为要加两个锁。实际上是两次判空。
 * 注意的点是 静态变量需要用 volatile 来禁止指令重排序
 */
class DoubleCheckLock {
    private volatile static DoubleCheckLock sInstance;

    public static DoubleCheckLock getInstance() {
        if (sInstance == null) {
            synchronized (DoubleCheckLock.class) {
                if (sInstance == null) {
                    sInstance = new DoubleCheckLock();
                }
            }
        }
        return sInstance;
    }
}
