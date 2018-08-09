package jvm.memory_error_sample;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

class MetaSpaceOOM {
    public static final int _10MB = 10 * 1014 * 1024;

    /**
     * DirectMemory容量可以通过MaxDirectMemorySize指定，如果不指定，则默认与Java堆最大值一样(-Xmx指定)
     *
     * 设置 jvm 参数：-Xmx20M -XX:MaxDirectMemorySize=10M
     */
    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);//获取 Unsafe 实例
        while (true) {
            unsafe.allocateMemory(_10MB);//使用 Unsafe 类直接分配内存
        }
    }

    /**
     * 运行结果：
     * Exception in thread "main" java.lang.OutOfMemoryError
     * 	at sun.misc.Unsafe.allocateMemory(Native Method)
     * 	at jvm.memory_error_sample.MetaSpaceOOM.main(MetaSpaceOOM.java:18)
     * */
}
