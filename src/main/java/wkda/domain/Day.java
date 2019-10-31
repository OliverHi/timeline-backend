package wkda.domain;

import java.util.List;

public class Day extends MockData {
    private String name;
    private List<Task> tasks;

    public Day(Integer id, String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
        this.id = id;
    }

    public Day() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
