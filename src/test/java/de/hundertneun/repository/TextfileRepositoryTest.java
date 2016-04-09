package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class TextfileRepositoryTest {

    @Test
    public void listMovies() throws Exception {
        TextfileRepository repo = new TextfileRepository(new ByteArrayInputStream((
                "Film1;blabla...\n" +
                        "Film2;blablabal....\n" +
                        "Film3;vlvlvlv").getBytes()
        ));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).extracting(Movie::getTitle).contains("Film1", "Film2", "Film3");
    }
}