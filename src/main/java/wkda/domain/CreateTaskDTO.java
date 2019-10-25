package wkda.domain;

public class CreateTaskDTO {
    private Task task;
    private int dayId;

    public Task getTask() {
        return task;
    }

    public int getDayId() {
        return dayId;
    }

    public CreateTaskDTO(Task task, int dayId) {
        this.task = task;
        this.dayId = dayId;
    }
}
