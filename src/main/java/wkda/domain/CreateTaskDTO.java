package wkda.domain;

public class CreateTaskDTO {
    private String task;
    private Long dayId;

    public CreateTaskDTO(String task, Long dayId) {
        this.task = task;
        this.dayId = dayId;
    }

    public CreateTaskDTO() {

    }

    public String getTask() {
        return this.task;
    }

    public Long getDayId() {
        return this.dayId;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CreateTaskDTO)) return false;
        final CreateTaskDTO other = (CreateTaskDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$task = this.getTask();
        final Object other$task = other.getTask();
        if (this$task == null ? other$task != null : !this$task.equals(other$task)) return false;
        final Object this$dayId = this.getDayId();
        final Object other$dayId = other.getDayId();
        if (this$dayId == null ? other$dayId != null : !this$dayId.equals(other$dayId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CreateTaskDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $task = this.getTask();
        result = result * PRIME + ($task == null ? 43 : $task.hashCode());
        final Object $dayId = this.getDayId();
        result = result * PRIME + ($dayId == null ? 43 : $dayId.hashCode());
        return result;
    }

    public String toString() {
        return "CreateTaskDTO(task=" + this.getTask() + ", dayId=" + this.getDayId() + ")";
    }
}
