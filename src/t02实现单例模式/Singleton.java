package t02实现单例模式;

/**
 * 关键：变量是私有且静态
 * 核心原理：
 * 一、构造函数私有化
 * 二、通过静态方法获取唯一的实例
 * <p>
 * 注意的问题：获取过程中，
 * 一、必须保证线程安全
 * 二、防止反序列化导致重新生成实例的问题
 */
public class Singleton {

}

/**
 * 双重校验锁的实现方式
 * <p>
 * 「双重校验锁」这个名字有误导性，容易让人误解——以为要加两个锁。实际上是两次判空。
 * 注意： 静态变量需要用 volatile 来禁止指令重排序
 */
class DoubleCheckLock {
    private volatile static DoubleCheckLock sInstance;

    private DoubleCheckLock() {
    }

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

    /**
     * 钩子函数，控制反序列化
     */
    private Object readResolve() {
        return sInstance;
    }

}

/**
 * 静态内部类
 */
class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    public static StaticInnerClassSingleton getInstance() {
        return Holder.sInstance;
    }

    private static class Holder {
        private static StaticInnerClassSingleton sInstance = new StaticInnerClassSingleton();
    }

}

/**
 * 不需要担心反序列问题
 */
enum EnumSingleton {
    SINGLETON
}

/**
 * 懒汉模式
 * 缺点：每次获取实例都需要使用
 */
class LazySingleton {
    private static LazySingleton sInstance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new LazySingleton();
        }
        return sInstance;
    }

    /**
     * 钩子函数，控制反序列化
     */
    private Object readResolve() {
        return sInstance;
    }
}


/**
 * 饿汉模式
 */
class HungrySingleton {
    public static final HungrySingleton sInstance = new HungrySingleton();

    private HungrySingleton() {
    }

    /**
     * 钩子函数，控制反序列化
     */
    private Object readResolve() {
        return sInstance;
    }
}