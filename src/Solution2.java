import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Java program to find the maximum stolen value 

public class Solution2 {
	static int number_of_cycles(List<Integer> arr) {
		Set<Integer> alreadyAppeared = new HashSet<>();
		Set<Integer> newLoop = null;
		int ans = 0;
		for (int i = 0; i < arr.size(); i++) {
			newLoop = new HashSet<>();
			int startEl = arr.get(i);
			while (startEl != i) {
				if (alreadyAppeared.contains(startEl))
					break;
				newLoop.add(startEl);
				startEl = arr.get(startEl);
			}
			if (startEl == i) {
				newLoop.add(startEl);
				alreadyAppeared.addAll(newLoop);
				ans++;
			}

		}

		return ans;

	}

	// driver program
	public static void main(String[] args) {
		List<Integer> rupee_notes = new ArrayList<Integer>();
		rupee_notes.add(4);
		rupee_notes.add(3);
		rupee_notes.add(1);
		rupee_notes.add(2);
		rupee_notes.add(0);
		rupee_notes.add(5);
		int result = number_of_cycles(rupee_notes);
		System.out.println(result);

	}
}

// Contributed by Pramod kumar 
