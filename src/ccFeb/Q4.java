package ccFeb;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class Q4 {

	static Stack<Long> sol = new Stack<>();

	static int populateEgyptian(long n, long d) {
		if (d == 0 || n == 0) {
			return 0;
		}

		long dNext = getNexDenominator(n, d);
		if (dNext >= 1000000) {
			long pop = sol.pop();
			sol.push(pop + 1);
			return 1;
		}
		sol.push(dNext);
		while (populateEgyptian(n * dNext - d, dNext * d) == 1) {
			dNext = sol.peek();
			populateEgyptian(n * dNext - d, dNext * d);
		}
		return 0;
	}

	private static long getNexDenominator(long n, long d) {
		if (d % n == 0)
			return d / n;
		return d / n + 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = in.nextInt();
			int d = in.nextInt();
			populateEgyptian(n, d);
			Set<Long> st = new LinkedHashSet<>();
			st.addAll(sol);
			for (Long s : st) {
				System.out.print(s + " ");
			}
			sol=new Stack<>();
		}
	}
}
