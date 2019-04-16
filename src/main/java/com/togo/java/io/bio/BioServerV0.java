package com.togo.java.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.togo.java.io.constant.SocketConstant;

/**
 * 
 * @author AI
 * @desc bio例子；打印服务，服务端；
 *
 * @date 2019年4月15日
 *
 */
public class BioServerV0 {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(SocketConstant.PORT);
		System.out.println("server start");

		Socket socket = server.accept();
		BufferedReader input = new BufferedReader(
				new InputStreamReader(socket.getInputStream(), "utf-8"));
		PrintWriter output = new PrintWriter(socket.getOutputStream());
		String msg = "";
		while (!msg.equals("quit")) {

			msg = input.readLine();
			System.out.println("client : " + msg);
			String sayHI = "no !" + msg;
			System.out.println("server : " + sayHI);
			output.println(sayHI);
			output.flush();
		}

		server.close();
		socket.close();
		input.close();
		output.close();
	}
}
