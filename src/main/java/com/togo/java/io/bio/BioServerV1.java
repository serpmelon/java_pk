package com.togo.java.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.togo.java.io.constant.SocketConstant;

/**
 * 
 * @author AI
 * @desc bio例子；打印服务，服务端；
 *
 * @date 2019年4月16日
 *
 */
public class BioServerV1 {

	static class HandleMsgThread implements Runnable {

		private Socket socket;
		private boolean shutdown = false;

		public HandleMsgThread(Socket socket) {

			this.socket = socket;
		}

		@Override
		public void run() {

			if (socket == null)
				throw new NullPointerException();

			BufferedReader input = null;
			PrintWriter output = null;

			try {
				Thread.sleep(10 * new Random().nextInt(10));
				input = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), SocketConstant.UTF8));
				output = new PrintWriter(socket.getOutputStream());
				String msg = "";

				while (!shutdown) {
					msg = input.readLine();
					if (msg != null && !msg.equals("quit")) {

						System.out.println("Thread " + Thread.currentThread().getName());
						System.out.println("client : " + socket.getPort() + " says :" + msg);

						output.println("shut up ! " + msg);
						output.flush();
					} else {
						shutdown = true;
					}

				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				output.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {

		List<Socket> list = new ArrayList<>();
		ServerSocket server = new ServerSocket(SocketConstant.PORT);
		System.out.println("server start");

		while (true) {

			Socket client = server.accept();
			list.add(client);
			Thread t = new Thread(new HandleMsgThread(client));
			t.start();
		}
	}
}
