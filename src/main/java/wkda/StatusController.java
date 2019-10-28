package wkda;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/api/status")
public class StatusController {
    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStatus() {
        return "Service is up and running";
    }
}
