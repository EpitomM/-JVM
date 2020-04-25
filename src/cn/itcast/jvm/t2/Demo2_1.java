package cn.itcast.jvm.t2;

import java.util.ArrayList;

/**
 *  演示内存的分配策略
 */
public class Demo2_1 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:-ScavengeBeforeFullGC
    // -Xms20M：初始堆空间20M；
    // -Xmx20M：最大堆空间20M；
    // -Xmn10M：新生代10M；
    // -XX:+UseSerialGC：垃圾回收器，幸存区比例不会动态调整
    // -XX:+PrintGCDetails -verbose:gc：打印 gc 详情
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);

        }).start();

        System.out.println("sleep....");
        Thread.sleep(1000L);
    }
}
