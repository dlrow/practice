import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Q2 {
	public static void main(String[] args) throws java.lang.Exception {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int x = 0, i = 0;
			for (i = 0; i < n; i++) {
				a[i] = a[i] + x;
				if (a[i] >= k) {
					int y = a[i] - k;
					x = y;
				} else {
					System.out.println("NO " + (i + 1));
					break;
				}
			}
			if (i == n)
				System.out.println("YES");

		}

		// your code goes here
	}
}