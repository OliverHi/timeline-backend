package wkda.repository;

import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import wkda.domain.Day;
import wkda.domain.Task;
import wkda.service.DayService;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TestDataProvider {

    private final DayService dayService;

    public TestDataProvider(final DayService service) {
        this.dayService = service;
    }

    @EventListener
    public void loadInitialData(final ServiceStartedEvent event) {
//        log.info("Loading data at startup");

        dayService.addDay(new Day("23/10/2019", getMutableTaskList(new Task("Did stuff"), new Task("Did more stuff"))));
        dayService.addDay(new Day("24/10/2019", getMutableTaskList(new Task("Fixed stuff from the day before"))));
        dayService.addDay(new Day("25/10/2019", getMutableTaskList(new Task("Hackathon"))));

//        log.info("Added data");
    }

    public List<Task> getMutableTaskList(Task... tasks) {
        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            taskList.add(task);
        }

        return taskList;
    }
}