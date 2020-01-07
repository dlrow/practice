package amazon;

import java.io.*;
import java.util.*;

public class TestClass {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int Q = Integer.parseInt(inp[1]);
		String[] arr_A = br.readLine().split(" ");
		int[] A = new int[N];
		for (int i_A = 0; i_A < arr_A.length; i_A++) {
			A[i_A] = Integer.parseInt(arr_A[i_A]);
		}
		int[] u = new int[N];
		int[] v = new int[N];
		for (int i_u = 0; i_u < N - 1; i_u++) {
			String[] tmp = br.readLine().split(" ");
			u[i_u] = Integer.parseInt(tmp[0]);
			v[i_u] = Integer.parseInt(tmp[1]);
		}

		int[] L = new int[Q];
		int[] X = new int[Q];
		for (int i_L = 0; i_L < Q; i_L++) {
			String[] tmp = br.readLine().split(" ");
			L[i_L] = Integer.parseInt(tmp[0]);
			X[i_L] = Integer.parseInt(tmp[1]);
		}

		int[] out_ = GreaterEqual(A, X, u, L, v);
		System.out.println(out_[0]);
		for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
			System.out.println(out_[i_out_]);
		}

		wr.close();
		br.close();
	}

	static Map<Integer, List<Integer>> adjList = new HashMap<>();

	static int[] GreaterEqual(int[] A, int[] X, int[] u, int[] L, int[] v) {
		for (int i = 0; i < u.length; i++) {
			if (!adjList.containsKey(u[i]))
				adjList.put(u[i], new ArrayList());
			adjList.get(u[i]).add(v[i]);
		}

		Map<Integer, List<Integer>> levelMap = new HashMap<>();
		levelMap.put(0, new ArrayList());
		levelMap.get(0).add(1);
		Integer levelMapCtr = 1;
		levelMap.put(1, new ArrayList());
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(null);
		int depth = 0;
		while (!q.isEmpty()) {
			Integer curr = q.remove();
			if (curr == null) {
				depth++;
				levelMapCtr++;
				levelMap.put(levelMapCtr, new ArrayList());
				if (!q.isEmpty())
					q.add(null);
				continue;
			}
			List<Integer> adjCurr = adjList.get(curr);
			if (adjCurr != null) {
				for (int j : adjCurr) {
					levelMap.get(levelMapCtr).add(j);
					q.add(j);
				}
			}
		}

		int sol[] = new int[L.length];
		for (int i = 0; i < L.length; i++) {
			List<Integer> curr = levelMap.get((L[i] ) % depth);
			int c = Integer.MAX_VALUE;
			if (curr != null) {
				for (int j : curr) {
					if (A[j-1] >= X[i] && A[j-1] < c)
						c = A[j-1];
				}
				if(c==Integer.MAX_VALUE)
					c=-1;
				sol[i] = c;
			}
		}
		return sol;
	}

}