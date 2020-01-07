package arcesium;

import java.util.Scanner;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n =in.nextInt();
		int sol[] = new int[m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int c = in.nextInt();
				if(c>sol[i])
					sol[i]=c;
			}
		}
		
		for(int i = 0;i<m;i++) {
			System.out.print(sol[i]+" ");
		}
	
	}
}
