import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Cell {
	int x;
	int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Amazon1 {
	public static void main(String[] args) {

		List<List<Integer>> aList = new ArrayList<>();

		// Create n lists one by one and append to the
		// master list (ArrayList of ArrayList)
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(0);
		a1.add(1);
		a1.add(1);
		a1.add(0);
		a1.add(1);
		aList.add(a1);

		/*
		 * ArrayList<Integer> a2 = new ArrayList<Integer>(); a2.add(5); aList.add(a2);
		 */
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(0);
		a3.add(1);
		a3.add(0);
		a3.add(1);
		a3.add(0);
		aList.add(a3);

		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(0);
		a4.add(0);
		a4.add(0);
		a4.add(0);
		a4.add(1);
		aList.add(a4);

		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(0);
		a5.add(1);
		a5.add(0);
		a5.add(0);
		a5.add(0);
		aList.add(a5);

		System.out.println(minDays(4, 5, aList));

	}
	
	

	public static int minDays(int row, int col, List<List<Integer>> inp) {

		int sol = 0;

		Set<Cell> serversUpdated = new HashSet<>();
		Queue<Cell> q = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (inp.get(i).get(j) == 1) {
					Cell c = new Cell(i, j);
					q.add(c);
					serversUpdated.add(c);
				}
			}
		}

		
		q.add(null);
		boolean seenNull = false;
		while (!q.isEmpty()) {
			Cell curr = q.poll();
			if (curr == null) {

				if (seenNull)
					break;
				sol++;
				if (serversUpdated.size() == row * col)
					break;
				q.add(null);
				seenNull = true;
				continue;
			}

			seenNull = false;
			if (isValid(row, col, curr.x - 1, curr.y, inp)) {
				Cell c = new Cell(curr.x - 1, curr.y);

				q.add(c);
				serversUpdated.add(c);
			}

			if (isValid(row, col, curr.x + 1, curr.y, inp)) {
				Cell c = new Cell(curr.x + 1, curr.y);
				q.add(c);
				serversUpdated.add(c);
			}

			if (isValid(row, col, curr.x, curr.y - 1, inp)) {
				Cell c = new Cell(curr.x, curr.y - 1);
				q.add(c);
				serversUpdated.add(c);
			}
			if (isValid(row, col, curr.x, curr.y + 1, inp)) {
				Cell c = new Cell(curr.x, curr.y + 1);
				q.add(c);
				serversUpdated.add(c);
			}

		}

		return sol;
	}

	private static boolean isValid(int row, int col, int x, int y, List<List<Integer>> inp) {
		boolean b = (x >= 0 && x < row && y >= 0 && y < col && inp.get(x).get(y) == 0);
		if (b)
			inp.get(x).set(y, 1);
		return b;
	}

}
