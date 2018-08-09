package jvm.memory_error_sample;

import java.util.ArrayList;
import java.util.List;

/**
 * heap oom 的一个栗子
 */
class HeapOOM {

    /**
     * 设置Java堆的大小20MB，将堆的最小值-Xms参数和最大值-Xmx参数设置为一样，
     * 避免堆自动扩展。
     * 通过设置参数-XX:+HeapDumpOnOutOfMemoryError，在发生内存异常时可以生成堆转存储的dump文件，
     * 可以通过Eclipse Memory Analyzer (MAT)工具分析该文件。
     * <p>
     * VM Args:
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new Byte[4096]);
        }
    }
}
