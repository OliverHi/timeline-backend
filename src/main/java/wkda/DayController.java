package wkda;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import wkda.domain.CreateDayDTO;
import wkda.domain.Day;
import wkda.service.DayService;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/day")
public class DayController {

    @Inject
    private DayService dayService;

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Day> getAllDays() {
        return dayService.getAllDays();
    }

    @Get("/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Day getDay(Long day) {
        return dayService.getDay(day);
    }

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Day addDay(@Body CreateDayDTO day) {
        return dayService.addDay(day);
    }

    @Delete("/{id}")
    public void deleteDay(Long id) {
        dayService.deleteDay(id);
    }
}