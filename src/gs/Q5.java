package gs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q5 {

	static Stack<Integer> sol = new Stack<>();
	static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {
		int profit = populateStack(maxCargoWeight,cargoList);		
		List<Integer> re = new LinkedList<>();
		re.addAll(sol);
		Collections.reverse(re);
		re.add(profit);
		return re;
	}

	private static int populateStack(int maxCargoWeight, List<List<Integer>> cargoList) {
		if(maxCargoWeight<1)
		
		
		return 0;
	}

	public static void main(String[] args) {

		List<List<Integer>> mat = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(38);
		row1.add(4);
		row1.add(500);
		List<Integer> row2 = new ArrayList<>();
		row2.add(21);
		row2.add(8);
		row2.add(1800);
		List<Integer> row3 = new ArrayList<>();
		row3.add(13);
		row3.add(3);
		row3.add(1500);

		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
		System.out.println(findTruckCargo(10, mat));
	}
}
