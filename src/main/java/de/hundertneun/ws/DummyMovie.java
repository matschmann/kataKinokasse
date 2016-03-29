package de.hundertneun.ws;

import de.hundertneun.vo.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Path("/dummyMovie")
public class DummyMovie {

    @GET
    @Produces("application/json")
    public Movie dummyMovie(){
        Movie movie = new Movie();
        movie.setTitle("Alice im Wunderland");
        movie.setDates(Arrays.asList(new Date()));
        
        return movie;
    }

}