package com.togo.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import com.togo.java.io.constant.SocketConstant;

public class NIOServerV0 {

	private Selector selector;

	public void init() throws IOException {

		this.selector = Selector.open();
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		ServerSocket serverSocket = channel.socket();
		InetSocketAddress address = new InetSocketAddress(SocketConstant.PORT);
		serverSocket.bind(address);
		channel.register(selector, SelectionKey.OP_ACCEPT);
	}

	public void start() throws IOException {

		while (true) {

			this.selector.select();
			Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
			while (it.hasNext()) {

				SelectionKey key = it.next();
				it.remove();
				if (key.isAcceptable()) {

					accept(key);
				} else if (key.isReadable()) {

					read(key);
				}
			}
		}
	}

	private void accept(SelectionKey key) throws IOException {

		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		SocketChannel channel = server.accept();
		channel.configureBlocking(false);
		channel.register(this.selector, SelectionKey.OP_READ);
	}

	private void read(SelectionKey key) throws IOException {

		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		String request = new String(buffer.array()).trim();

		System.out.println("client request : " + request);

		ByteBuffer outBuffer = ByteBuffer.wrap("收到请求".getBytes());
		channel.write(outBuffer);
	}

	public static void main(String[] args) throws IOException {

		NIOServerV0 server = new NIOServerV0();
		server.init();
		server.start();
	}
}
