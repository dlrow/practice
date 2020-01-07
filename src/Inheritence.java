import java.util.ArrayList;
import java.util.List;

class Player{
	int a;
	private void foo() {
		
	}
}
class B extends Player {
	int b;
	public void foo() {
		
	}
}

class C extends Player {
	int c;
	public void foo() {
		
	}
}
public class Inheritence {
	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		Player p1 = new B();
		Player p2 = new C();
		players.add(p2);
		players.add(p1);
		
		
		
	}

}
