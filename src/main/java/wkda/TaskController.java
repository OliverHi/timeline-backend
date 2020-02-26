package wkda;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import wkda.domain.CreateTaskDTO;
import wkda.domain.Task;
import wkda.service.TaskService;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/task")
public class TaskController {

    @Inject
    private TaskService taskService;

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Get("/{task}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTask(Long task) {
        return taskService.getTask(task);
    }

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Task addTask(@Body CreateTaskDTO createTaskDTO) {
        return taskService.addTask(createTaskDTO.getTask(), createTaskDTO.getDayId());
    }

    @Delete("/{id}")
    public void deleteTask(Long id) {
        taskService.deleteTask(id);
    }
}
