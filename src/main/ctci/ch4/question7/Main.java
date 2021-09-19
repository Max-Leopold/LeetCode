package main.ctci.ch4.question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		Project a = new Project("a");
		Project b = new Project("b");
		Project c = new Project("c");
		Project d = new Project("d");
		Project e = new Project("e");
		Project f = new Project("f");

		Dependency da = new Dependency(d, a);
		Dependency bf = new Dependency(b, f);
		Dependency db = new Dependency(d, b);
		Dependency ad = new Dependency(a, f);
		Dependency cd = new Dependency(c, d);

		List<Project> projects = new ArrayList<>();
		projects.add(a);
		projects.add(b);
		projects.add(c);
		projects.add(d);
		projects.add(e);
		projects.add(f);

		List<Dependency> dependencies = new ArrayList<>();
		dependencies.add(da);
		dependencies.add(bf);
		dependencies.add(db);
		dependencies.add(ad);
		dependencies.add(cd);

		System.out.println(Arrays.toString(
				Solution.getBuildOrder(projects, dependencies).toArray()
		));
	}
}
