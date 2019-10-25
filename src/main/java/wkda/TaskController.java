package wkda;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import wkda.domain.CreateTaskDTO;
import wkda.domain.Task;
import wkda.service.DayService;
import wkda.service.TaskService;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/task")
public class TaskController {

    @Inject
    private TaskService taskService;

    @Inject
    private DayService dayService;

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Get("/{Task}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTask(Integer Task) {
        return taskService.getTask(Task);
    }

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void addTask(@Body CreateTaskDTO createTaskDTO) {
        dayService.addTaskToDay(createTaskDTO.getTask(), createTaskDTO.getDayId());
    }

    @Delete("/{id}")
    public void deleteTask(int id) {
        taskService.deleteTask(id);
    }
}
