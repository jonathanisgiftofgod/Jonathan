package userDefineMap;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapChild {
	public static void main(String[] args) {
		HashMap<Integer, Employee> has = new HashMap<Integer, Employee>();
		
		Employee E = new Employee();
		E.setId(1);
		E.setName("Britto");
		
		Employee E1 = new Employee();
		E1.setId(2);
		E1.setName("Joseph");
	
		has.put(10, E);
		has.put(20, E1);
		
		Set<Entry<Integer, Employee>> entrySet = has.entrySet();
		for (Entry<Integer, Employee> x : entrySet) {
			Employee value = x.getValue();
			System.out.println(value.getId());
			System.out.println(value.getName());
		}
	}
}
