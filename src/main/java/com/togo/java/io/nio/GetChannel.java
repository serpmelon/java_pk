package com.togo.java.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {

		String dir = "C:\\Users\\AI\\Desktop\\";
		String path = dir + "data.txt";
		FileChannel fileChannel = new FileOutputStream(path).getChannel();
		fileChannel.write(ByteBuffer.wrap("some words".getBytes()));
		fileChannel.close();

		fileChannel = new RandomAccessFile(path, "rw").getChannel();
		fileChannel.position(fileChannel.size());
		fileChannel.write(ByteBuffer.wrap("\n more".getBytes()));
		fileChannel.close();

		fileChannel = new FileInputStream(path).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fileChannel.read(buffer);
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.println((char) buffer.get());
		}
	}
}
