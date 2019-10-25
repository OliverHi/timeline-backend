package wkda.domain;


public class Task extends MockData {
    private String task;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Task(String task) {
        this.task = task;
    }

    public Task() {
    }
}
