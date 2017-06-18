package Xebia.SampleMavenProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetConcepts {

	static Set<Object> iset = new HashSet<>();
	static List<Object> ilist = new ArrayList<Object>();
	static List<Object> isortedlist = new ArrayList<Object>();
	static Set<Object> isortedset = new TreeSet<Object>();

	public static void main(String[] args) {
		int count[] = { 10, 15, 5, 50, 12, 10 };

		for (int i = 0; i < count.length; i++) {
			iset.add(count[i]);
			ilist.add(count[i]);
		}
		ilist.add(1, 15);
		iset.add("Test");
		iset.add("ABC");
		// isortedset.addAll(iset);
		System.out.println(iset);
		System.out.println(ilist);
		System.out.println(isortedset);
		for (Object i : isortedset) {
			System.out.println(i);
		}

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		Iterator<Object> itr = isortedset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println(ilist);

	}
}
