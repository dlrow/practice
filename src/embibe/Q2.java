package embibe;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int x=in.nextInt();
		int y=in.nextInt();
		System.out.println(barterMarket(n, m, x, y));

	}

	public static int barterMarket(int n, int m, int x, int y) {

		int numcoinbook=m/x;
		int maxFicCanBuy=Math.min(n, (n*y+m)/(x+y));
		
		return 0;
	}

}