import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//1 3 5 5 6 3 7 5 9
//8 3 5 5 2 3  4 9 6

public class HelloWorld {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int elem = getMaxFrequencyBiggest(a);
		System.out.println(elem);
		

	}

	private static int getMaxFrequencyBiggest( int[] a) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!m.containsKey(a[i])) {
				m.put(a[i], 0);
			}
			int count =  m.get(a[i])+1;
			m.put(a[i],count);
		}

		int maxFrequency = 0;
		int element=0;
		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			if(entry.getValue()>maxFrequency && entry.getKey()>element) {
				maxFrequency=entry.getValue();
				element=entry.getKey();
			}
		}
		return element;
	}
}