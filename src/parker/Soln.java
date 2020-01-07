package parker;

import java.util.Arrays;
import java.util.Scanner;

public class Soln {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);

		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			System.out.println(count(arr, n, left, right));
			;
		}

	}

	public static int count(int arr[], int n, int left, int right) {
		int count = 0;
		count = up(arr, n, right) - low(arr, n, left) + 1;
		return count;
	}

	public static int low(int arr[], int n, int search) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= search)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static int up(int arr[], int n, int search) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= search)
				l = mid + 1;
			else
				h = mid - 1;
		}
		return h;
	}

}