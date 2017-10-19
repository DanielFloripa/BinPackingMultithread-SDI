package bpp;

import java.util.Random;

public class App {

	public static void main2(String[] args) {
		System.out.println("Starting...");
		Thread t1 =new Thread(new Runnable() {
			
			public void run() {
				Random ran = new Random();
				
				for (int i=0;i<1E6;i++) {

					Double dRand = ran.nextDouble();
					
					try {
						Thread.sleep(dRand.longValue());
					} catch (InterruptedException e) {
						System.out.println("Interrupted!");
						break;
						//e.printStackTrace();
					}
					
					Double dSin = Math.sin(dRand);
					System.out.println("i: "+i+", dRand: "+dRand+", sin: "+dSin);
				}
			}
		});
		
		t1.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		t1.interrupt();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
