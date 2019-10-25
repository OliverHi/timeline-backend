package wkda.service;

import wkda.domain.Task;
import wkda.repository.TaskRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(int id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(int id) {
        taskRepository.delete(id);
    }

    public void deleteTasks(Integer... ids) {
        for (int id : ids) {
            taskRepository.delete(id);
        }
    }

    public Task addTask(Task newTask) {
        return taskRepository.add(newTask);
    }

    public void updateTask(Task updatedTask) {
        taskRepository.update(updatedTask.getId(), updatedTask);
    }
}
