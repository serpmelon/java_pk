package com.togo.java.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static class Soldier implements Runnable {

		private String name;
		private final CyclicBarrier cyclic;

		public Soldier(CyclicBarrier cyclic, String name) {

			this.cyclic = cyclic;
			this.name = name;
		}

		public void run() {

			try {
				cyclic.await();
				Thread.sleep(100);
				System.out.println(name + "： finished");
				cyclic.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class BarrierRun implements Runnable {

		boolean flag;
		int N;

		public BarrierRun(boolean flag, int N) {

			this.flag = flag;
			this.N = N;
		}

		public void run() {

			if (flag) {

				System.out.println("soldier " + N + ", finished");
			} else {

				System.out.println("soldier " + N + ", collected");
				flag = true;
			}
		}

	}

	public static void main(String[] args) {

		final int N = 10;
		Thread[] allSoldier = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));

		for (int i = 0; i < N; i++) {
			System.out.println("soldier_" + i);
			allSoldier[i] = new Thread(new Soldier(cyclic, "soldier_" + i));
			allSoldier[i].start();
		}
	}
}
