import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//i/p
//2 list strings 
//list of pairs which are similar
//good day
//awesome day
//(bad,worse), (good,awesome)

public class Sol {
	public static void main(String[] args) {
		Queue q = new LinkedList();
		q.add(1);
		q.add("asd");
		
		System.out.println(q);
	}

	public static boolean isSimilar(List<String> s1, List<String> s2, List<ArrayList<String>> similar) {
		Set<String> stringsPresent = new HashSet<>();

		if (s1.size() != s2.size()) {
			return false;
		}

		for (ArrayList<String> l : similar) {
			stringsPresent.add(l.get(0));
			stringsPresent.add(l.get(1));
		}

		int i = 0;
		for (i = 0; i < s1.size(); i++) {
			if (s1.get(i).equalsIgnoreCase(s2.get(i)))
				continue;

			if (stringsPresent.contains(s1.get(i)) && stringsPresent.contains(s2.get(i))) {
				if (!isStringsSame(s1.get(i), s2.get(i), similar, stringsPresent))
					break;

			}

		}

		return (i == s1.size());
	}

	private static boolean isStringsSame(String string, String string2, List<ArrayList<String>> similar,
			Set<String> stringsPresent) {
		Map<String, List<String>> graph = new HashMap();
		for (ArrayList<String> l : similar) {
			if(graph.containsKey(l.get(0))) {
				graph.get(l.get(0)).add(l.get(1));
				for(String s : graph.get(l.get(0))) {
					//graph.get(key)
				}
			}
			if(graph.containsKey(l.get(1))) {
				graph.get(l.get(1)).add(l.get(0));
			}
			List<String> curr = new ArrayList<>();
			curr.add(l.get(1));
			graph.put(l.get(0), curr);
			List<String> curr2 = new ArrayList<>();
			curr2.add(l.get(0));
			graph.put(l.get(1), curr2);
			
		}
		return false;
	}

}
