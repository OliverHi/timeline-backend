package wkda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class StatusControllerTest {

    @Inject
    @Client("/api")
    RxHttpClient client;

    @Test
    public void testGetDays() {
        HttpRequest<String> request = HttpRequest.GET("/status");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Service is up and running", body);
    }
}