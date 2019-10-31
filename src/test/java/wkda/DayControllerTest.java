package wkda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import wkda.domain.Day;
import java.util.List;

import javax.inject.Inject;

@MicronautTest
public class DayControllerTest {

    @Inject
    @Client("/api/day")
    RxHttpClient client;

    @Test
    public void getAllDays() {
        HttpRequest<String> request = HttpRequest.GET("/");
        List<Day> allDays = client.toBlocking().retrieve(request, List.class);

        assertNotNull(allDays);
        assertEquals(5, allDays.size());
    }

    @Test
    void getADay() {
        HttpRequest<String> request = HttpRequest.GET("/5");
        Day day = client.toBlocking().retrieve(request, Day.class);

        assertNotNull(day);
        assertEquals("25/10/2019", day.getName());
    }
}