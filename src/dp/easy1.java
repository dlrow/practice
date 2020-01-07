package dp;

import java.util.Scanner;

//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/xsquare-and-two-arrays/
public class easy1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int a[] = new int[n + 1];
		int b[] = new int[n + 1];
		long sumA[] = new long[n + 1];
		long sumB[] = new long[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = in.nextInt();
			sumA[i] = sumA[i - 1] + a[i];
		}

		for (int i = 1; i < n + 1; i++) {
			b[i] = in.nextInt();
			sumB[i] = sumB[i - 1] + b[i];
		}

		for (int i = 0; i < q; i++) {
			int j = in.nextInt();
			int k = in.nextInt();
			int l = in.nextInt();
			if (j == 1)
				System.out.println(getSum(a, sumA, k, l));
			else
				System.out.println(getSum(b, sumB, k, l));
		}
	}

	private static long getSum(int[] a, long[] sumA, int k, int l) {
		return sumA[l] - sumA[k-1];
	}

}
