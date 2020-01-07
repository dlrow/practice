package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinSingDigitPrimeToMakeN {
	static Map<Integer, Integer> dp = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			dp = new HashMap<>();
			int ans = getMinPrime(in.nextInt());
			System.out.println(ans);
			t--;
		}
	}

	private static int getMinPrime(int n) {
		if (n == 2 || n == 3 || n == 5 || n == 7)
			return 1;
		if (n < 2)
			return Integer.MAX_VALUE;
		if (dp.containsKey(n))
			return dp.get(n);
		int mn = 0;
		if (n < 100)
			mn = getMin(getMinPrime(n - 2), getMinPrime(n - 3), getMinPrime(n - 5), getMinPrime(n - 7));
		else
			mn = getMinPrime(n - 7);
		dp.put(n, mn + 1);
		return dp.get(n);
	}

	private static Integer getMin(int a, int b, int c, int d) {
		int arr[] = { a, b, c, d };
		Arrays.sort(arr);
		return arr[0];
	}
}
