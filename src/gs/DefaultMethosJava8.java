package gs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface I1{
	default void show() {
		System.out.println("I1 show");
	}
}

interface I2{
	/*default void show() {
		System.out.println("I2 show");
	}*/
}
class Conen implements I1,I2{

		public void conMet() {
			System.out.println("conen method");
		}
	
	
}

public class DefaultMethosJava8 {
	public static void main(String[] args) {
		I1 c = new Conen();
		c.show();
		Map<String,String> m = new HashMap<>();
	//	Map<String,String> m = new ConcurrentHashMap();
	}

}
