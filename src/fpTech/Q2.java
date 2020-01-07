package fpTech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point {
	int start;
	int end;

	public Point(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}

public class Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			int totalMarksCoverd = 0;
			List<Point> points = new ArrayList<>();
			// Map<Integer, Integer> veh = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				int s = in.nextInt();
				int e = in.nextInt();
				Point p = new Point(s, e);
				points.add(p);
				// veh.put(s, e);
			}

			Collections.sort(points, (p1, p2) -> {
				return (p1.start - p2.start);
			});

			for (int i = 0; i < n; i++) {
				int start = points.get(i).start;
				int end = points.get(i).end;
				while (i < n - 1 && points.get(i + 1).start <= end) {
					i++;
					if (points.get(i).end > end)
						end = points.get(i).end;
				}

				
				totalMarksCoverd = totalMarksCoverd + (end - start)+1;
			}

			System.out.println(totalMarksCoverd);
			t--;
		}
	}

}
