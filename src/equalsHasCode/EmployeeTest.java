package equalsHasCode;

import java.util.HashSet;
import java.util.Set;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee(1,"Ab",99055,"Shivpuri");
		Employee e2 = new Employee(1,"Ab",99055,"Shivpuri");
		Employee e3 = new Employee(2,"CAb",990550,"palk street");
		Employee e4 = new Employee(1,"Abc",99055366,"new town");
		Set<Employee> empSet = new HashSet<>();
		
		empSet.add(e1);
		empSet.add(e2);
		empSet.add(e3);
		empSet.add(e4);
		
	}

}
