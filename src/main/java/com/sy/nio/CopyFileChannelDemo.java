package com.sy.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2025/4/17 15:17
 * @Modified By:
 * @Version: 1.0
 */
public class CopyFileChannelDemo {
    public static void main(String[] args) {
        try {
            //准备输入流文件
            FileInputStream fileInputStream = new FileInputStream("D:\\data\\sfhm.txt");
            //准备输出流文件
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\data\\sfhm_copy.txt");

            //获取输入流的通道
            FileChannel inputStreamChannel = fileInputStream.getChannel();
            FileChannel outputStreamChannel = fileOutputStream.getChannel();

            //复制
            inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel);

            //关注资源
            fileInputStream.close();
            outputStreamChannel.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
