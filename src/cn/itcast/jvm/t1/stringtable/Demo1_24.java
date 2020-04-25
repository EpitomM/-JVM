package cn.itcast.jvm.t1.stringtable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 演示串池大小对性能的影响
 *  -XX:StringTableSize=1009：设置 hash 桶个数
 * -Xms500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=1009
 */
public class Demo1_24 {

    public static void main(String[] args) throws IOException {
        // 读取文件：文件里存放一堆单词
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"), "utf-8"))) {
            String line = null;
            long start = System.nanoTime();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                // 单词本内每个单词入串池
                line.intern();
            }
            System.out.println("cost:" + (System.nanoTime() - start) / 1000000 +"ms");
        }


    }
}
