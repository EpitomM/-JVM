package cn.itcast.jvm.t1.stringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示 StringTable 垃圾回收
 * -Xmx10m ：设置堆内存虚拟机的最大值
 * -XX:+PrintStringTableStatistics：打印字符串表的统计信息，可以看到常量池中字符串实例的个数和大小信息
 * -XX:+PrintGCDetails -verbose:gc：打印垃圾回收的详细信息，包括垃圾回收的次数、花费时间等
 *
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 */
public class Demo1_7 {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        try {
            for (int j = 0; j < 100; j++) { // j=100, j=10000
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }

    }
}
