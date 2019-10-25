package wkda.repository;

import wkda.domain.Day;
import wkda.domain.Task;

import javax.inject.Inject;
import java.util.Arrays;

public class TestDataProvider {

    @Inject
    private DayRepository dayRepository;

    public void initTestData() {
        dayRepository.add(new Day("20.10.2019", Arrays.asList(new Task("Do stuff"), new Task("Do more stuff"))));
        dayRepository.add(new Day("21.10.2019", Arrays.asList(new Task("Fix stuff from the day before"))));
        dayRepository.add(new Day("22.10.2019", Arrays.asList(new Task("A meeting"), new Task("Another meeting"), new Task("How many meetings are there??!"))));
    }
}
