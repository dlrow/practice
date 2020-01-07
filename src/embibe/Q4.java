package embibe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int input = in.nextInt();
			System.out.println(numOfWays(input));
		}
	}

	static Map<Integer, Integer> dp = new HashMap<>();

	private static int numOfWays(int n) {
		if (n % 2 != 0 || n == 0)
			return 0;
		dp.put(2, 1);
		dp.put(4, 2);
		dp.put(6, 4);
		if (dp.containsKey(n))
			return dp.get(n);
		dp.put(n, numOfWays(n - 2) + numOfWays(n - 4) + numOfWays(n - 6));
		return dp.get(n);
	}

}