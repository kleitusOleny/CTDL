package Lab8.set_student;

import java.util.HashSet;
import java.util.Set;

public class TestPredicates {
	public static void main(String[] args) {
		Set<Integer> list = new HashSet<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println("---Remove---");
		Set<Integer>list1 = new HashSet<>();
		list1.addAll(list);
		System.out.println("Before: "+list1);
		MyPredicates.remove(list1, new Even());
		System.out.println("After: "+list1);
		
		System.out.println("---Retain---");
		Set<Integer>list2 = new HashSet<>();
		list2.addAll(list);
		System.out.println("Before: "+list2);
		MyPredicates.retain(list2, new Even());
		System.out.println("After: "+list2);
		
		System.out.println("---Collect---");
		Set<Integer>list3 = new HashSet<>();
		list3.addAll(list);
		System.out.println("Before: "+list3);
		System.out.println("Result: "+ MyPredicates.collect(list3,new Even()));
		
		System.out.println("---Find---");
		Set<Integer> list4 = new HashSet<>();
		list4.addAll(list);
		System.out.println("Before: "+list3);
		System.out.println("Result: "+ MyPredicates.find(list4, new Even()));
	}
}
