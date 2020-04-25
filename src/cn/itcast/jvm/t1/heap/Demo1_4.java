package cn.itcast.jvm.t1.heap;

/**
 * 演示堆内存
 */
public class Demo1_4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(3000);
        byte[] array = new byte[1024 * 1024 * 10]; // 10 Mb，new 关键字创建的，占用堆空间
        System.out.println("2...");
        Thread.sleep(2000);
        array = null;// 引用设为空
        System.gc();// 垃圾回收
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
