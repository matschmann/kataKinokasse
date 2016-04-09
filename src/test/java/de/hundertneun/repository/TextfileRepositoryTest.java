package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.List;

public class TextfileRepositoryTest {

    @Test
    public void listMovies() throws Exception {
        TextfileRepository repo = new TextfileRepository(new FileInputStream("data/Vorstellungen.txt"));

        List<Movie> movies = repo.listMovies();

        assertThat(movies).extracting(Movie::getTitle).contains("Der Schuh des Königs", "Pumuckl", "Der Name der Rose");
    }
}