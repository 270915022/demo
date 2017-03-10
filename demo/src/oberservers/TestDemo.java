package oberservers;

import java.util.HashSet;
import java.util.Set;

public class TestDemo {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		Object[] array = set.toArray();
		System.out.println(array.length);
	}
}
