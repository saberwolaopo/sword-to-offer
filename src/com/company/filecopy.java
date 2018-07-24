package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class filecopy {
    public static void main(String []argv) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\Person.txt");

        FileChannel inChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //创建输出流，如果没有这个文件，会自动创建这个文件
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\1223.txt");

        FileChannel outChannel = fileOutputStream.getChannel();

        while(true){
            int eof = inChannel.read(byteBuffer);
            if(eof == -1){
                break;
            }
            else{
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
        
        inChannel.close();
        outChannel.close();
    }
}
