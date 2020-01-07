package arcesium;

import java.util.Stack;

public class Sol3 {
public static int find(String s) {
		
		int count=0;
		int c=0;
		
		Stack<Character> s1= new Stack<Character>();
		s1.push('1');
		Stack<Character> s2= new Stack<Character>();
		s2.push('0');
		
		for(int i=0;i<s.length();i++) {
			if(s1.peek() == s.charAt(i) && s.charAt(i)=='1') {
				s1.push('0');
				count++;
			}
			
			else if(s1.peek() == s.charAt(i) && s.charAt(i)=='0') {
				s1.push('1');
				count++;
			}
			else {
				s1.push(s.charAt(i));
			}
			
			
		}
		
		for(int i=0;i<s.length();i++) {
			if(s2.peek() == s.charAt(i) && s.charAt(i)=='1') {
				s2.push('0');
				c++;
			}
			
			else if(s2.peek() == s.charAt(i) && s.charAt(i)=='0') {
				s2.push('1');
				c++;
			}
			else {
				s2.push(s.charAt(i));
			}
			
			
		}		
		return (Math.min(count,c));

	}
}
