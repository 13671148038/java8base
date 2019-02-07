package com.balimiao;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNio {
    @Test
    public void test1() throws Exception {
        RandomAccessFile write = new RandomAccessFile("pom222.xml", "rw");
        FileChannel writeChannel = write.getChannel();


        RandomAccessFile read = new RandomAccessFile("pom.xml", "r");
        FileChannel readChannel = read.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10000);

        int count = 1;
        while (readChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
            count++;
            System.out.println(count);
        }
        writeChannel.close();
        readChannel.close();
    }

    //文件的复制  channel是异步进行的
    @Test
    public void test2() throws Exception {
        OutputStream outputStream = new FileOutputStream("data/target.txt", true);
        FileChannel targetChannel = ((FileOutputStream) outputStream).getChannel();
        RandomAccessFile randomAccessFile = new RandomAccessFile("data/source.txt", "r");
        FileChannel channel = randomAccessFile.getChannel();
        channel.transferTo(0, channel.size(), targetChannel);
        channel.close();
        targetChannel.close();
    }
}
