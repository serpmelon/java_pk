package com.togo.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
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

				} else if (key.isReadable()) {

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
	
	private void read(SelectionKey key) {
		
		SocketChannel channel = (SocketChannel) key.channel();
	}
}
