package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Show;
import de.hundertneun.Application;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class FileShowRepositoryTest {

    @Test
    public void listMovies() throws Exception {
        FileShowRepository repo = new FileShowRepository(new ByteArrayInputStream((
                "Film1;Mo/17:00/Saal 1/8.00\n" +
                        "Film2;Mo/17:00/Saal 1/8.00\n" +
                        "Film3;Mo/17:00/Saal 1/8.00").getBytes()
        ));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).extracting(Movie::getTitle).contains("Film1", "Film2", "Film3");
    }

    @Test
    public void listMovies_emptyInptStream() throws Exception {
        FileShowRepository repo = new FileShowRepository(new ByteArrayInputStream(("").getBytes()));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).isEmpty();
    }

    @Test
    public void listShowsByMovie() throws Exception {
        FileShowRepository repository = new FileShowRepository(new ByteArrayInputStream(
                "Film1;Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00".getBytes()
        ));

        List<Show> film1 = repository.listShowsByMovie(new Movie("Film1").getId());

        assertThat(film1).hasSize(2);
        assertThat(film1).containsExactlyInAnyOrder(
                new Show(Application.CURRENT_DATE_TIME.plusHours(17), new BigDecimal(7), "Saal 1"), 
                new Show(Application.CURRENT_DATE_TIME.plusHours(20), new BigDecimal(8), "Saal 1") 
                );
    }

    @Test
    public void listAvaliableSeats() throws Exception {
        FileShowRepository repository = new FileShowRepository(new ByteArrayInputStream(
                "Film1;Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00".getBytes()
        ));
        
        List<Show> shows = repository.listShowsByMovie(repository.listMovies().get(0).getId());
        UUID showId = shows.get(0).getId();

        assertThat(repository.listAvaliableSeats(showId)).hasSize(112);

        System.out.println(repository.reserveSeat(showId, 4));
        System.out.println(repository.reserveSeat(showId, 5));
        System.out.println(repository.reserveSeat(showId, 18));
        System.out.println(repository.reserveSeat(showId, 19));
        System.out.println(repository.reserveSeat(showId, 20));

        assertThat(repository.listAvaliableSeats(showId)).hasSize(107);

    }
}