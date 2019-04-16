package com.togo.java.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author AI
 * @desc
 *
 * @date 2019年4月15日
 *
 */
public class BioSimpleClient {

	public static void main(String[] args) {

		// socket不能同事开启输入输出流？
		try {
			Socket client = new Socket("localhost", 5000);
			PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			output.write("hi");
			output.flush();
			BufferedReader input = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			System.out.println("from server " + input.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
