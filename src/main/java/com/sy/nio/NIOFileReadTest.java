package com.sy.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2025/4/17 14:29
 * @Modified By:
 * @Version: 1.0
 */
public class NIOFileReadTest {

    public static void main(String[] args) {
        String filePath = "D:\\data\\sfhm.txt";
        //StandardOpenOption.READ
        try (FileChannel fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);//分配内存,创建时默认写模式
            long startTime = System.currentTimeMillis();
            while (fileChannel.read(buffer) != -1) {
                buffer.flip(); // 变成读模式

                /**
                 * buffer.hasRemaining() 方法的作用是检查当前 ByteBuffer 中是否还有未读取的元素。它通过比较 position 和 limit 来判断：
                 * 如果 position < limit，返回 true，表示还有数据可以读取。
                 * 如果 position >= limit，返回 false，表示数据已经全部读取完毕。
                 * 在你的代码中，while (buffer.hasRemaining()) 的作用是确保在 buffer 中还有未读取的数据时，继续读取数据。这是典型的 ByteBuffer 读取操作流程的一部分，用于逐字节或逐块处理缓冲区中的数据。
                 */
                while (buffer.hasRemaining()) {
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);

                    //转码
                    System.out.print(new String(bytes, "UTF-8"));
                }
                buffer.clear(); // 最后又变成写模式，让继续写
            }
            long endTime = System.currentTimeMillis();
            System.out.println();
            System.out.println("Time taken to read the file: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
