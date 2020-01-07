package fpTech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();

			Map<Integer, List<Integer>> adj = new HashMap<>();
			for (int i = 0; i < n - 1; i++) {
				int s = in.nextInt();
				int d = in.nextInt();
				if (!adj.containsKey(s)) {
					adj.put(s, new ArrayList<>());
				}
				adj.get(s).add(d);
			}
			int root = in.nextInt();
			int min = getMin(adj, root);
			System.out.println(min);
			t--;
		}
	}

	private static int getMin(Map<Integer, List<Integer>> adj, int root) {
		Queue<Integer> q = new LinkedList<>();
		if(adj.get(root)==null) {
			return root;
		}
		q.add(root);
		q.add(0);
		Set<Integer> probableSoln = new HashSet<>();
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == 0) {
				if (!q.isEmpty()) {
					q.add(0);
					min = getMin(probableSoln);
					probableSoln = new HashSet<>();
					continue;
				}
				break;
			}
			List<Integer> ad = adj.get(curr);
			if (ad != null) {
				for (Integer i : ad) {
					q.add(i);
					probableSoln.add(i);
				}
			}

		}

		return min;
	}

	private static int getMin(Set<Integer> probableSoln) {
		int min;
		min = Integer.MAX_VALUE;
		for (int i : probableSoln) {
			min = min < i ? min : i;
		}
		return min;
	}

	private static int getRoot(Set<Integer> reachable, int n) {
		for (int i = 1; i <= n; i++) {
			if (!reachable.contains(i))
				return i;
		}
		return 0;
	}

}
