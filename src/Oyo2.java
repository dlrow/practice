import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Oyo2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(3);
		arr.add(2);
		arr.add(4);
		arr.add(2);
		arr.add(3);
		
		System.out.println(subsetA(arr));

	}

	public static List<Integer> subsetA(List<Integer> arr) {
		List<Integer> subA = new LinkedList<>();
		Collections.sort(arr);
		Long sum = 0L;
		for(int i: arr) {
			sum+=i;
		}
		Long subASum=0L;
		Long sumHalf = sum/2;
		for(int i=arr.size()-1;subASum<sumHalf;i--) {
			subA.add(arr.get(i));
			subASum+=Long.valueOf(arr.get(i));
		}
		
		Collections.reverse(subA);
		
		return subA;
	}
}
