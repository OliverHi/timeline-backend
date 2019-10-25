package wkda.repository;

import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import wkda.domain.Day;
import wkda.domain.Task;
import wkda.service.DayService;

import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
public class TestDataProvider {
    /**
     * Reactive repository for Mongo database to store
     * Conference objects with an id and name property.
     */
    private final DayService dayService;

    public TestDataProvider(final DayService service) {
        this.dayService = service;
    }

    @EventListener
    public void loadInitialData(final ServiceStartedEvent event) {
//        log.info("Loading data at startup");

        dayService.addDay(new Day("20.10.2019", Arrays.asList(new Task("Do stuff"), new Task("Do more stuff"))));
        dayService.addDay(new Day("21.10.2019", Arrays.asList(new Task("Fix stuff from the day before"))));
        dayService.addDay(new Day("22.10.2019", Arrays.asList(new Task("A meeting"), new Task("Another meeting"), new Task("How many meetings are there??!"))));

//        log.info("Added data");
    }
}