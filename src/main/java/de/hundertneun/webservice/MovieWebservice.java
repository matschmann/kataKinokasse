package de.hundertneun.webservice;

import de.hundertneun.repository.ShowRepository;
import de.hundertneun.repository.MockShowRepository;
import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Show;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class MovieWebservice {

    ShowRepository showRepository;

    public MovieWebservice() {
        showRepository = new MockShowRepository();
    }

    @GET @Path("/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> allMovies(){
        return showRepository.listMovies();
    }

    @GET
    @Path("/shows/{movieTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Show> showsForMovie(@PathParam("movieTitle") String movieTitle) {
        List<Show> shows = showRepository.listShowsByMovie(new Movie(movieTitle).getId());

        if (shows.isEmpty()) {
            throw new WebApplicationException(404);
        }
        
        return shows;
    }
}