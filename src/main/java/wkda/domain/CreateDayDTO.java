package wkda.domain;

import java.util.Objects;

public class CreateDayDTO {
    private String name;

    public CreateDayDTO(String name) {
        this.name = name;
    }

    public CreateDayDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDayDTO that = (CreateDayDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CreateDayDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
