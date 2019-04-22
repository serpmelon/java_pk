package com.togo.java.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {

		String dir = "C:\\Users\\AI\\Desktop\\";
		String path = dir + "data.txt";
		String src = path;
		String tar = dir + "target.txt";

		FileChannel input = new FileInputStream(path).getChannel(),
				output = new FileOutputStream(tar).getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(input.read(buffer) != -1) {
			buffer.flip();
			output.write(buffer);
			buffer.flip();
		}
	}
}
