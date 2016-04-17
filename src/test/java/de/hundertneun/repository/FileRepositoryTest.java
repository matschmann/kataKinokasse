package de.hundertneun.repository;

import de.hundertneun.App;
import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Show;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.List;

public class FileRepositoryTest {

    @Test
    public void listMovies() throws Exception {
        FileRepository repo = new FileRepository(new ByteArrayInputStream((
                "Film1;Mo/17:00/Saal 1/8.00\n" +
                        "Film2;Mo/17:00/Saal 1/8.00\n" +
                        "Film3;Mo/17:00/Saal 1/8.00").getBytes()
        ));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).extracting(Movie::getTitle).contains("Film1", "Film2", "Film3");
    }

    @Test
    public void listMovies_emptyInptStream() throws Exception {
        FileRepository repo = new FileRepository(new ByteArrayInputStream(("").getBytes()));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).isEmpty();
    }

    @Test
    public void testName() throws Exception {
        FileRepository repository = new FileRepository(new ByteArrayInputStream(
                "Film1;Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00".getBytes()
        ));

        List<Show> film1 = repository.listShows(new Movie("Film1"));

        assertThat(film1).hasSize(2);
        assertThat(film1).containsExactlyInAnyOrder(
                new Show(App.CURRENT_DATE_TIME.plusHours(17), new BigDecimal(7), "Saal 1"), 
                new Show(App.CURRENT_DATE_TIME.plusHours(20), new BigDecimal(8), "Saal 1") 
                );

    }

}