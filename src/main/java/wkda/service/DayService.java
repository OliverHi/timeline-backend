package wkda.service;

import wkda.domain.CreateDayDTO;
import wkda.domain.Day;
import wkda.repository.DayRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static io.micronaut.core.util.CollectionUtils.iterableToList;

@Singleton
public class DayService {

    @Inject
    private DayRepository dayRepository;
    
    public List<Day> getAllDays() {
        return iterableToList(dayRepository.findAll());
    }
    
    public Day getDay(Long id) {
        return dayRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public void deleteDay(Long id) {
        dayRepository.deleteById(id);
    }

    public Day addDay(CreateDayDTO createDayDTO) { ;
        return dayRepository.save(new Day(null, createDayDTO.getName(), new ArrayList<>()));
    }

    public void updateDay(Day updatedDay) {
        dayRepository.save(updatedDay);
    }
}
