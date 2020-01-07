package ccFeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

		}
		in.close();
	}

	Map<String, Integer> nameMap = new HashMap<>();
	static void entityExpansion(long l, List<String> entities) {
		
		for (String entity : entities) {
			String name = getName(entity);
			List<Integer> values = getValues(entity);
		}

	}

	private static List<Integer> getValues(String entity) {
		int sp=entity.lastIndexOf(' ' );
		String s=entity.substring(sp,entity.length());
		
	}

	private static String getName(String entity) {
		int sp = entity.indexOf(' ');
		int en = entity.indexOf(' ', sp + 1);
		String name = entity.substring(sp, en);
		return name;
	}

}
