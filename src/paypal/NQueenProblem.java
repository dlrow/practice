package paypal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueenProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			int placed[][] = new int[n][n];
			if(n==2 || n==3) {
				System.out.println(-1);
				continue;
			}
			for (int i = 0; i < n; i++) {
				printPath(0, i, n, placed, 0);
			}

			t--;
			for (List<Integer> l : sol) {
				System.out.print("[");
				for (int a : l) {
					System.out.print(a + " ");
				}
				System.out.print("] ");
			}
			sol = new ArrayList<>();
		}

	}

	static List<List<Integer>> sol = new ArrayList<>();

	public static void printPath(int i, int j, int n, int placed[][], int queensPlaced) {
		if (!isValidMove(i, j, placed, n))
			return;
		queensPlaced++;
		placed[i][j] = 1;
		if (queensPlaced == n) {
			addSol(placed);
			placed[i][j] = 0;
			return;
		}
		for (int k = 2; k < n; k++) {
			if (j + k < n && i + 1 < n)
				printPath(i + 1, j + k, n, placed, queensPlaced);

			if (j - k >= 0 && i + 1 < n)
				printPath(i + 1, j - k, n, placed, queensPlaced);

		}
		placed[i][j] = 0;
		queensPlaced--;

	}

	public static boolean isValidMove(int ci, int cj, int placed[][], int n) {
		if (ci < 0 || ci >= n || cj < 0 || cj >= n)
			return false;
		// check row
		for (int i = 0; i < n; i++) {
			if (placed[ci][i] == 1)
				return false;
		}

		// check column
		for (int i = 0; i < n; i++) {
			if (placed[i][cj] == 1)
				return false;
		}

		// checkLeftDiagonal upwards
		for (int i = ci, j = cj; i < n && i >= 0 && j < n && j >= 0; i--, j++) {
			if (placed[i][j] == 1)
				return false;
		}
		// checkLeftDiagonal downwards
		for (int i = ci, j = cj; i < n && i >= 0 && j < n && j >= 0; i++, j--) {
			if (placed[i][j] == 1)
				return false;
		}

		// checkRightDiagonal upwards
		for (int i = ci, j = cj; i < n && i >= 0 && j < n && j >= 0; i--, j--) {
			if (placed[i][j] == 1)
				return false;
		}
		// checkRightDiagonal downwards
		for (int i = ci, j = cj; i < n && i >= 0 && j < n && j >= 0; i++, j++) {
			if (placed[i][j] == 1)
				return false;
		}

		return true;
	}

	private static void addSol(int[][] placed) {
		List<Integer> li = new ArrayList<>();

		for (int i = 0; i < placed.length; i++) {
			for (int j = 0; j < placed.length; j++) {
				if (placed[i][j] == 1) {
					li.add(j + 1);
				}
			}
		}
		sol.add(li);
	}

}
