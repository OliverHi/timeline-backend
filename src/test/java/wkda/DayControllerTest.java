package wkda;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import wkda.domain.CreateDayDTO;
import wkda.domain.Day;

import javax.inject.Inject;
import java.util.List;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpRequest.POST;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class DayControllerTest {

    @Inject
    @Client("/api/day")
    RxHttpClient client;

    // TODO init DB for tests and write seperate ones

    @Test
    void testFullDayLifecycle() {
        // create one day
        CreateDayDTO newDay = new CreateDayDTO("A bright new day");
        Day createdDay = client.toBlocking().retrieve(POST("/", newDay), Day.class);

        assertEquals(newDay.getName(), createdDay.getName());
        assertNull(createdDay.getTasks());
        assertNotNull(createdDay.getId());

        // create another day
        CreateDayDTO anotherDay = new CreateDayDTO("Another bright new day");
        Day createdDay2 = client.toBlocking().retrieve(POST("/", anotherDay), Day.class);

        assertEquals(anotherDay.getName(), createdDay2.getName());
        assertNull(createdDay2.getTasks());
        assertNotNull(createdDay2.getId());

        // get first day
        Day firstCreatedDay = client.toBlocking().retrieve(GET("/" + createdDay.getId()), Day.class);

        assertNotNull(firstCreatedDay);
        assertEquals(createdDay.getName(), firstCreatedDay.getName());

        List<Day> allDays = client.toBlocking().retrieve(GET("/"), List.class);

        assertNotNull(allDays);
        assertEquals(2, allDays.size());

        // delete days
        client.toBlocking().exchange(HttpRequest.DELETE("/" + createdDay.getId()));
        client.toBlocking().exchange(HttpRequest.DELETE("/" + createdDay2.getId()));

        // no days left
        List<Day> allDaysLeft = client.toBlocking().retrieve(GET("/"), List.class);
        assertNotNull(allDaysLeft);
        assertEquals(0, allDaysLeft.size());
    }
}