package main.ctci.ch4.question7;

class Dependency {

	private final Project project;
	private final Project dependentOn;

	public Dependency(Project project, Project dependentOn) {
		this.project = project;
		this.dependentOn = dependentOn;
	}

	public Project getProject() {
		return project;
	}

	public Project getDependentOn() {
		return dependentOn;
	}
}
