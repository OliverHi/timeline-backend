package wkda;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import wkda.domain.CreateDayDTO;
import wkda.domain.CreateTaskDTO;
import wkda.domain.Day;
import wkda.domain.Task;

import javax.inject.Inject;

import java.util.List;

import static io.micronaut.http.HttpRequest.*;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class TaskControllerTest {

    @Inject
    @Client("/api/task")
    RxHttpClient taskClient;

    @Inject
    @Client("/api/day")
    RxHttpClient dayClient;

    @Test
    void testFullTaskLifecycle() {
        // create one day
        CreateDayDTO newDay = new CreateDayDTO("A bright new day");
        Day createdDay = dayClient.toBlocking().retrieve(POST("/", newDay), Day.class);

        assertEquals(newDay.getName(), createdDay.getName());
        assertNull(createdDay.getTasks());
        assertNotNull(createdDay.getId());

        // create a task for the first day
        CreateTaskDTO newTask = new CreateTaskDTO("A very important task", createdDay.getId());
        Task createdTask = taskClient.toBlocking().retrieve(POST("/", newTask), Task.class);

        assertEquals(newTask.getTask(), createdTask.getTask());
        assertNotNull(createdTask.getId());
//        assertEquals(createdDay, createdTask.getDay());

        // get task
        Task firstTask = taskClient.toBlocking().retrieve(GET("/" + createdTask.getId()), Task.class);
        assertEquals(createdTask.getTask(), firstTask.getTask());
        assertEquals(createdTask.getId(), firstTask.getId());
        assertEquals(createdTask.getDay(), firstTask.getDay());

        // delete task
        taskClient.toBlocking().exchange(DELETE("/" + createdTask.getId()));
        dayClient.toBlocking().exchange(HttpRequest.DELETE("/" + createdDay.getId()));

        // no tasks left
        List<Task> allTasksLeft = taskClient.toBlocking().retrieve(GET("/"), List.class);
        assertNotNull(allTasksLeft);
        assertEquals(0, allTasksLeft.size());
    }
}