package main.ctci.ch4.question7;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static List<Project> getBuildOrder(List<Project> projects, List<Dependency> dependencies) throws Exception {
		Queue<Project> projectsWithOutDependency = new LinkedList<>(projects);
		Hashtable<Project, Integer> dependenciesUntilFree = new Hashtable<>();
		Hashtable<Project, List<Project>> frees = new Hashtable<>();
		List<Project> buildOrder = new ArrayList<>();

		dependencies.forEach(dependency -> {
			projectsWithOutDependency.remove(dependency.getProject());
			dependenciesUntilFree.put(
					dependency.getProject(),
					dependenciesUntilFree.getOrDefault(dependency.getProject(), 0) + 1
			);
			List<Project> freedByProject = frees.getOrDefault(dependency.getDependentOn(), new ArrayList<>());
			freedByProject.add(dependency.getProject());
			frees.put(
					dependency.getDependentOn(),
					freedByProject
			);
		});

		while (!projectsWithOutDependency.isEmpty()) {
			Project nextToBuild = projectsWithOutDependency.poll();
			buildOrder.add(nextToBuild);
			frees.getOrDefault(nextToBuild, new ArrayList<>()).forEach(
					freedProject -> {
						dependenciesUntilFree.computeIfPresent(
								freedProject,
								(key, val) -> val - 1
						);
						if (dependenciesUntilFree.get(freedProject) == 0) {
							projectsWithOutDependency.add(freedProject);
						}
					}
			);
		}

		if (buildOrder.size() == projects.size()) {
			return buildOrder;
		}
		throw new Exception("Can't create buildOrder");
	}
}
