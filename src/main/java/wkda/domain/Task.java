package wkda.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column(name = "task", nullable = false)
    private String task;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @NotNull
    private Day day;

    public Task(Long id, @NotNull String task, Day day) {
        this.id = id;
        this.task = task;
        this.day = day;
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getTask() {
        return this.task;
    }

    public Day getDay() {
        return this.day;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(@NotNull String task) {
        this.task = task;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Task)) return false;
        final Task other = (Task) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$task = this.getTask();
        final Object other$task = other.getTask();
        if (this$task == null ? other$task != null : !this$task.equals(other$task)) return false;
        final Object this$day = this.getDay();
        final Object other$day = other.getDay();
        if (this$day == null ? other$day != null : !this$day.equals(other$day)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Task;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $task = this.getTask();
        result = result * PRIME + ($task == null ? 43 : $task.hashCode());
        final Object $day = this.getDay();
        result = result * PRIME + ($day == null ? 43 : $day.hashCode());
        return result;
    }

    public String toString() {
        return "Task(id=" + this.getId() + ", task=" + this.getTask() + ", day=" + this.getDay() + ")";
    }
}
