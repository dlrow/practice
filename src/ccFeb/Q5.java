package ccFeb;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int x = 0, y = 0, prevDis = Integer.MAX_VALUE;
			int d = getDistance(in, x, y);
			while (d > 0) {

			}
			if (d < 0) {
				System.exit(0);
			}
			if (d == 0) {
				printAns(in, x, y);
			}
		}
		in.close();
	}

	private static int getDistance(Scanner in, int x, int y) {
		System.out.println("Q " + x + " " + y);
		int d = in.nextInt();
		return d;
	}
	
	private static void printAns(Scanner in, int x, int y) {
		System.out.println("Q " + 0 + " " + y);
		int xl = in.nextInt();
		System.out.println("Q " + x + " " + 0);
		int yl = in.nextInt();
		System.out.println("Q " + 1000000001 + " " + y);
		int xm = in.nextInt();
		int xu = 1000000001 - xm;
		System.out.println("Q " + x + " " + 1000000001);
		int ym = in.nextInt();
		int yu = 1000000001 - ym;
		System.out.println("A " + xl + " " + yl + " " + xu + " " + yu);

	}

}
