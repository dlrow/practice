package paypal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q2 {
	static Set<Pair> setN;
	static Set<Pair> setM;
	static Set<Pair> setK;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int x = in.nextInt();
			int y = in.nextInt();
			Pair startingpt = new Pair(x, y);
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			setN = new HashSet<>();
			setM = new HashSet<>();
			setK = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair p = new Pair(a, b);
				setN.add(p);
			}
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair p = new Pair(a, b);
				setM.add(p);
			}
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair p = new Pair(a, b);
				setK.add(p);
			}

			double ans = solve(startingpt);
			System.out.println(ans);
		}
	}

	private static double solve(Pair sp) {
		for(Pair)
	}

}
