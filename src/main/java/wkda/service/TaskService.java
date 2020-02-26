package wkda.service;

import wkda.domain.Day;
import wkda.domain.Task;
import wkda.repository.TaskRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;
import java.util.List;

import static io.micronaut.core.util.CollectionUtils.iterableToList;

@Singleton
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private DayService dayService;

    public List<Task> getAllTasks() {
        return iterableToList(taskRepository.findAll());
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteTasks(Long... ids) {
        for (Long id : ids) {
            taskRepository.deleteById(id);
        }
    }

    public Task addTask(Task newTask) {
        return taskRepository.save(newTask);
    }

    public Task addTask(String newTask, Long dayId) {
        Day dayForTask = dayService.getDay(dayId);
        Task task = new Task(null, newTask, dayForTask);
        return taskRepository.save(task);
    }

    public void updateTask(Task updatedTask) {
        taskRepository.save(updatedTask);
    }
}
