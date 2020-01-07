import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Oyo3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println(smallestString(20));

	}

	public static String smallestString(long weight) {
		String abc="ABCDEFGHIJKLMNOPQRSTU";
		String sol = "";
		long[] charWt = new long[21];
		calCharWt(charWt);
		while(weight!=0) {
			int index = getNextChar(weight,charWt);
			weight-=charWt[index];
			sol+=abc.charAt(index);
		}
		String ans="";
		for(int i=sol.length()-1;i>=0;i--)
			ans+=sol.charAt(i);
		return ans;
	}

	private static int getNextChar(long weight, long[] charWt) {
		int i=20;
		for(;i>0;i--) {
			if(charWt[i]<=weight)
				break;
		}
		return i;
	}


	private static void calCharWt(long[] charWt) {
		charWt[0] = 1;
		for (int i = 1; i < 21; i++) {
			charWt[i] = (i + 1) * charWt[i - 1] + charWt[i - 1];
		}

	}

}
