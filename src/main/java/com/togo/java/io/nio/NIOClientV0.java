package com.togo.java.io.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import com.togo.java.io.constant.SocketConstant;

public class NIOClientV0 {

	private Selector selector;
	private BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

	public void init() throws Exception {

		this.selector = Selector.open();
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress("127.0.0.1", SocketConstant.PORT));
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	public void start() throws Exception {

		while (true) {
			selector.select();
			Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();

			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				if (key.isConnectable()) {
					connect(key);
				} else if (key.isReadable()) {
					read(key);
				}
			}
		}
	}

	public void connect(SelectionKey key) throws Exception {

		SocketChannel channel = (SocketChannel) key.channel();
		if (channel.isConnectionPending()) {

			if (channel.finishConnect()) {

				channel.configureBlocking(false);
				channel.register(selector, SelectionKey.OP_READ);
				String request = clientInput.readLine();
				channel.write(ByteBuffer.wrap(request.getBytes()));
			} else {
				key.cancel();
			}
		}
	}

	public void read(SelectionKey key) throws Exception {

		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		String response = new String(buffer.array()).trim();

		System.out.println("server response : " + response);

		String nextRequest = clientInput.readLine();
		ByteBuffer outBuffer = ByteBuffer.wrap(nextRequest.getBytes());
		channel.write(outBuffer);
	}

	public static void main(String[] args) throws Exception {

		NIOClientV0 client = new NIOClientV0();
		client.init();
		client.start();
	}
}
