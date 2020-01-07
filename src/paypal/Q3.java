package paypal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {
	public static void main(String a[]) {
		Scanner in = new Scanner(System.in);
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1);
		l.add(1);
		l.add(1);
		list.add(l);
		list.add(l);
		list.add(l);
		System.out.println(mySqrt(list));
		// mySqrt(list);

	}

	static int dp[][];

	public static int mySqrt(List<List<Integer>> a) {
		int row = a.size();
		int col = a.get(0).size();
		dp = new int[row][col];
		
		return getNumPath(a, 0, 0, row, col);
	}

	private static int getNumPath(List<List<Integer>> a, int i, int j, int row, int col) {
		if (!isValidMove(i, j, a, row, col))
			return 0;
		if (i == row - 1 && j == col - 1)
			return 1;
		if (dp[i][j] != 0)
			return dp[i][j];
		else
			dp[i][j] = getNumPath(a, i + 1, j, row, col) + getNumPath(a, i, j + 1, row, col);
		return dp[i][j];
	}

	public static boolean isValidMove(int i, int j, List<List<Integer>> a, int row, int col) {
		return (i < row && j < col && a.get(i).get(j) == 1);
	}
}