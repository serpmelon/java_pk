package com.togo.java.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author AI
 * @desc bio例子；打印服务，服务端；
 *
 * @date 2019年4月15日
 *
 */
public class BioServer {

	private static ExecutorService tp = Executors.newCachedThreadPool();

	static class HandleMsg implements Runnable {

		Socket clientSocket = null;

		public HandleMsg(Socket clientSocket) {

			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {

			try (BufferedReader input = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);) {

				String inputLine = null;
				long begin = System.currentTimeMillis();
				inputLine = input.readLine();
				while ((inputLine = input.readLine()) != null) {
					output.println(inputLine);
				}
				long end = System.currentTimeMillis();
				System.out.println("spend : " + (end - begin) + " ms");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		ServerSocket echoServer = new ServerSocket(5000);
		Socket clientSocket = null;

		while (true) {
			clientSocket = echoServer.accept();
			System.out.println(clientSocket.getRemoteSocketAddress() + " connect !");
			tp.execute(new HandleMsg(clientSocket));
		}
	}
}
