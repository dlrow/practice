package paypal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q1 {

	static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {
		int n = cargoList.size();
		int ksack[][] = new int[n + 1][maxCargoWeight + 1];
		int i, w;
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= maxCargoWeight; w++) {
				if (w == 0 || i == 0)
					ksack[i][w] = 0;
				else if (cargoList.get(i - 1).get(1) <= w)
					ksack[i][w] = Math.max(ksack[i - 1][w],
							cargoList.get(i - 1).get(2) + ksack[i - 1][w - cargoList.get(i - 1).get(1)]);
				else
					ksack[i][w] = ksack[i - 1][w];
			}
		}

		w = maxCargoWeight;
		int answ = ksack[cargoList.size()][maxCargoWeight];
		List<Integer> chosenElements = new LinkedList<>();
		for (i = n; i > 0 && answ > 0; i--) {
			if (answ == ksack[i - 1][w])
				continue;
			else {
				chosenElements.add(cargoList.get(i - 1).get(0));
				answ = answ - cargoList.get(i - 1).get(2);
				w = w - cargoList.get(i - 1).get(1);
			}
		}

		Collections.reverse(chosenElements);
		chosenElements.add(ksack[cargoList.size()][maxCargoWeight]);
		return chosenElements;
	}

	public static void main(String[] args) {

		List<List<Integer>> mat = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(38);
		row1.add(4);
		row1.add(50);
		List<Integer> row2 = new ArrayList<>();
		row2.add(21);
		row2.add(8);
		row2.add(180);
		List<Integer> row3 = new ArrayList<>();
		row3.add(13);
		row3.add(3);
		row3.add(150);

		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
		System.out.println(findTruckCargo(10, mat));
	}
}
