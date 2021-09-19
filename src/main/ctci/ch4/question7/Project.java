package main.ctci.ch4.question7;

import java.util.Objects;

class Project {
	private final String name;

	public Project(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Project)) return false;
		Project project = (Project) o;
		return Objects.equals(name, project.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "Project{" +
				"name='" + name + '\'' +
				'}';
	}
}
