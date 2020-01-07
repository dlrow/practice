package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class ContinousArraySum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			int s = in.nextInt();
			int arr[] = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			
			long currSum = 0;
			int beginIndex = 0;
			int f=0;
			
			for (int i = 0; i < n; i++) {
				currSum = currSum + arr[i];
				while (currSum > s) {
					currSum -= arr[beginIndex++];
				}
				if (currSum == s) {
					System.out.println(beginIndex + 1 + " " + (i+1));
					f=1;
					break;
				}

			}
			if(f==0)
			System.out.println(-1);
			t--;
		}
	}

}
