package cn.itcast.jvm.t3.jit;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class JIT2 {
    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:CompileCommand=dontinline,*JIT2.square
    // -XX:+PrintCompilation

    public static void main(String[] args) {

        int x = 0;
        // 计时 500 次
        for (int i = 0; i < 500; i++) {
            // 统计调用 1000 次 square 方法的用时
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                x = square(9);

            }
            long end = System.nanoTime();
            System.out.printf("第%d次循环\t计算结果=%d\t用时=%d\n",i,x,(end - start));
        }
    }

    private static int square(final int i) {
        return i * i;
    }
}
