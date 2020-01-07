import java.util.List;

public class Q5 {
	public static void main(String[] args) {
		try {
			int a = 2 / 0;
			System.out.println("SAd");
		} catch (NullPointerException e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}
		System.out.println("after catch");
	}
}

class Solutiona {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	int minimumDays(int rows, int columns, List<List<Integer>> grid) {
		// this is maintened to mark server on diff days
		int version = 1;
		boolean isAllUpdated = false;
		while (!isAllUpdated) {
			int ct = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (grid.get(i).get(j) == version) {
						ct = ct + markAdjacentAsVisited(rows, columns, i, j, grid, version);

					}
				}
			}

			// if none of the cells are updated int this cycle
			if (ct == 0)
				isAllUpdated = true;
			else {
				version++;
			}
		}

		return version - 1;

	}

	// this method marks all adjacent cells from cell(i,j) as updated
	int markAdjacentAsVisited(int row, int col, int i, int j, List<List<Integer>> grid, int version) {

		int ct = 0;

		// marking all adjacnt cell to curr cell
		if (isValidCell(row, col, i + 1, j, grid)) {
			grid.get(i + 1).set(j, version + 1);
			ct = 1;
		}
		if (isValidCell(row, col, i - 1, j, grid)) {
			grid.get(i - 1).set(j, version + 1);
			ct = 1;
		}
		if (isValidCell(row, col, i, j + 1, grid)) {
			grid.get(i).set(j + 1, version + 1);
			ct = 1;
		}
		if (isValidCell(row, col, i, j - 1, grid)) {
			grid.get(i).set(j - 1, version + 1);
			ct = 1;
		}

		// returning a flag if any cell is updated
		return ct;

	}

	// this method checks if the cell is valid for update
	boolean isValidCell(int row, int col, int i, int j, List<List<Integer>> grid) {
		return (i >= 0 && i < row && j >= 0 && j < col && grid.get(i).get(j) == 0);
	}

	// METHOD SIGNATURE ENDS
}
