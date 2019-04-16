package com.togo.java.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.togo.java.io.constant.SocketConstant;

/**
 * 
 * @author AI
 * @desc
 *
 * @date 2019年4月15日
 *
 */
public class BioSimpleClientV0 {

	public static void main(String[] args) throws Exception {

		Socket client = new Socket(SocketConstant.HOST, SocketConstant.PORT);

		PrintWriter output = new PrintWriter(client.getOutputStream());
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		String hi = "";

		while (!(hi = keyboard.readLine()).equals("quit")) {

			output.println(hi);
			output.flush();

			BufferedReader input = new BufferedReader(
					new InputStreamReader(client.getInputStream(), "utf-8"));
			String line = input.readLine();
			System.out.println("server : " + line);
		}

		client.close();
		output.close();
	}
}
