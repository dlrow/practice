package turvo;

import java.io.*;
import java.util.*;

class Num {
	int val;
	int steps;

	public Num(int val, int steps) {
		this.val = val;
		this.steps = steps;
	}
}

public class TC3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] temp = br.readLine().split(" ");
			int X = Integer.parseInt(temp[0]);
			int A = Integer.parseInt(temp[1]);
			int B = Integer.parseInt(temp[2]);
			long out_ = number_creation(A, X, B);
			System.out.println(out_);

		}

		wr.close();
		br.close();
	}

	static long number_creation(int A, int X, int B) {

		Set<Num> visited = new HashSet<>(100000);
		LinkedList<Num> queue = new LinkedList<Num>();
		long ans = Long.MAX_VALUE;
		Num node = new Num(1, A);

		queue.offer(node);
		//visited.add(node);

		while (!queue.isEmpty()) {
			Num temp = queue.poll();
			visited.add(temp);
			
			if (temp.val == X) {
				if(ans>temp.steps)
					ans= temp.steps;
			}

			int mul = temp.val * 2;
			int sub = temp.val - 1;
			int add = temp.val+1;

			if (mul > 0 && mul < 200001) {
				Num nodeMul = new Num(mul, temp.steps + B);
				queue.offer(nodeMul);
			}
			if (sub > 0 && sub < 200001) {
				Num nodeSub = new Num(sub, temp.steps + A);
				queue.offer(nodeSub);
			}
			if (add > 0 && add < 200001) {
				Num nodeAdd = new Num(add, temp.steps + A);
				queue.offer(nodeAdd);
			}
		}
		return ans;

	}

}