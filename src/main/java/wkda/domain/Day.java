package wkda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Day extends MockData {
    private String name;
    private List<Task> tasks;
}
