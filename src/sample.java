import java.util.ArrayList;
import java.util.List;

public class sample {
	static class m{
		
	}
	public static void method(int i, List<m> arr) {
		if (i == 1) {
			arr=new ArrayList<>();
			System.out.println(arr.toString());
			return;
		}
		System.out.println("i="+i+" "+arr.toString());
		arr.add(new m());
		i--;
		method(i,arr);
		//arr.add(i);
		System.out.println("i="+i+" "+arr.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<m> arr = new ArrayList<>();
		arr.add(new m());
		int i=10;
		//method(i,arr);
		System.out.println(arr);
		cleanList(arr);
		System.out.println(arr);
	}

	private static void cleanList(List<m> arr) {
		arr.remove(0);
		System.out.println(arr);
		
	}

}
