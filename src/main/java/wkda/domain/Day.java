package wkda.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "day", fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    public Day(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Day(Long id, @NotNull String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public Day() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Day)) return false;
        final Day other = (Day) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$tasks = this.getTasks();
        final Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Day;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $tasks = this.getTasks();
        result = result * PRIME + ($tasks == null ? 43 : $tasks.hashCode());
        return result;
    }

    public String toString() {
        return "Day(id=" + this.getId() + ", name=" + this.getName() + ", tasks=" + this.getTasks() + ")";
    }
}
