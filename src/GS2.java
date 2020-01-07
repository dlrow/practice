import java.util.List;

public class GS2 {
	public static void main(String[] args) {

	}

	public int numTeams(List<Integer> coders) {
		int sol = 0;
		int n = coders.size();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (coders.get(i) < coders.get(j) && coders.get(j) < coders.get(k))
						sol++;
					else if (coders.get(i) > coders.get(j) && coders.get(j) > coders.get(k))
						sol++;
				}
			}
		}
		return sol;
	}

}
