import java.util.ArrayList;
import java.util.List;

// Java program to find the maximum stolen value 

public class Solution3 
{ 
	static int maxLoot(List<Integer> jars) 
	{ 
		int size =jars.size();
		if (size == 0) 
			return 0; 

		if (size == 1) 
			return jars.get(0); 

		int v1 = jars.get(0); 
		int v2 = Math.max(jars.get(0),jars.get(1)); 
		if (size == 2) 
			return v2; 
	
		int ans = 0; 

		for (int i=2; i<size; i++) 
		{ 
			ans = Math.max(jars.get(i)+v1, v2); 
			v1 = v2; 
			v2 = ans; 
		} 

		return ans; 
	} 
	
	// driver program 
	public static void main (String[] args) 
	{ 
		List<Integer> rupee_notes = new ArrayList<Integer>();
    	rupee_notes.add(10);rupee_notes.add(20);rupee_notes.add(30);rupee_notes.add(10);
       int result = maxLoot(rupee_notes);
       System.out.println(result);

	} 
} 

// Contributed by Pramod kumar 
