package dp;

import java.util.Scanner;

public class CoinPiles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(getMinNumber(n, k, arr));
		}

	}

	private static int getMinNumber(int n, int k, int[] arr) {
		int sol = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] > k) {
				sol += (arr[i] - arr[i - 1]) - k;
				arr[i] = arr[i] - ((arr[i] - arr[i - 1]) - k);
			}
		}
		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] - arr[i] > k) {
				sol += (arr[i - 1] - arr[i]) - k;
				arr[i - 1] = arr[i - 1] - ((arr[i - 1] - arr[i]) - k);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
		for (int i = 1; i < n; i++) {
			System.out.print(arr[i]-arr[i-1]+" ");
		}
		return sol;
	}

}
