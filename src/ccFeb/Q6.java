package ccFeb;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();

			long ans = 0;
			for (int i = 0; i < n; i++) {
				ans = ans + in.nextInt();
			}

			System.out.println(ans - n + 1);

		}
		in.close();
	}

}
