package wkda.service;

import wkda.domain.Day;
import wkda.domain.Task;
import wkda.repository.DayRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class DayService {

    @Inject
    private DayRepository dayRepository;

    @Inject TaskService taskService;
    
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }
    
    public Day getDay(int id) {
        return dayRepository.findById(id);
    }
    
    public void deleteDay(int id) {
        deleteTasksOfDay(id);
        dayRepository.delete(id);
    }

    public Day addDay(Day newDay) {
        dayRepository.add(newDay);
        newDay.getTasks().forEach(taskService::addTask);
        return newDay;
    }

    public void updateDay(Day updatedDay) {
        deleteTasksOfDay(updatedDay.getId());
        dayRepository.update(updatedDay.getId(), updatedDay);
        updatedDay.getTasks().forEach(taskService::addTask);
    }

    public void addTaskToDay(Task newTask, int dayId) {
        Day day = this.getDay(dayId);
        day.getTasks().add(newTask);
        updateDay(day);
    }

    private void deleteTasksOfDay(int id) {
        Integer[] orphanTasks = dayRepository.findById(id).getTasks().stream()
                .map(Task::getId).toArray(Integer[]::new);

        taskService.deleteTasks(orphanTasks);
    }
}
