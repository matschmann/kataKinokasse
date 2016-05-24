package de.hundertneun.webservice;

import de.hundertneun.repository.MockShowRepository;
import de.hundertneun.repository.ShowRepository;
import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Show;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieWebservice {

    ShowRepository showRepository;

    public MovieWebservice() {
        showRepository = new MockShowRepository();
    }

    @RequestMapping("/movies")
    public List<Movie> allMovies(){
        return showRepository.listMovies();
    }

    @RequestMapping("/shows")
    public List<Show> showsForMovie(@RequestParam(value="movieTitle")  String movieTitle) {
        List<Show> shows = showRepository.listShowsByMovie(new Movie(movieTitle).getId());

        if (shows.isEmpty()) {
            throw new RuntimeException("404");
        }
        
        return shows;
    }
}