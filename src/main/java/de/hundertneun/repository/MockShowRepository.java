package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Room;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MockShowRepository implements ShowRepository {

    public static final Movie MOVIE1 = new Movie("Der Stadtneurotiker");
    public static final Movie MOVIE2 = new Movie("Alice");
    public static final Movie MOVIE3 = new Movie("Hollywood Ending");
    public static final Movie MOVIE4 = new Movie("Harry außer sich");

    private final List<Movie> movies;

    public MockShowRepository() {
        movies = new ArrayList<>();
        movies.add(MOVIE1);
        movies.add(MOVIE2);
        movies.add(MOVIE3);
        movies.add(MOVIE4);
    }


    @Override
    public List<Movie> listMovies() {
        return movies;
    }

    @Override
    public List<Show> listShowsByMovie(UUID movieId) {

        boolean found = false; 
        for (Movie movie : movies) {    //TODO Java8 syntax
            if (movie.getId().equals(movieId)) {
                found = true; 
            }
        }

        if (!found) {
            return Collections.emptyList();
        }
        
        switch ((int) (movieId.getMostSignificantBits() % 4)) {
            case 0:
                return createDates(0);
            case 1:
                return createDates(-15);
            case 2:
                return createDates(30);
            case 3:
                return createDates(-30);
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public boolean reserveSeat(UUID showId, int seatNumber) {
        return false;
    }

    @Override
    public boolean isSeatAvailable(UUID showId, int seatNumber) {
        return false;
    }

    @Override
    public List<Seat> listAvaliableSeats(UUID showId) {
        return null;
    }

    private List<Show> createDates(int offset) {
        return Arrays.asList(
                new Show(LocalDateTime.of(2016, 4, 4, 17, 30).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 4, 20, 0).plusMinutes(offset), BigDecimal.valueOf(7.00), "Saal 1"),

                new Show(LocalDateTime.of(2016, 4, 5, 17, 30).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 5, 20, 0).plusMinutes(offset), BigDecimal.valueOf(8.00), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 6, 17, 15).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 6, 21, 0).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 6, 23, 0).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),

                new Show(LocalDateTime.of(2016, 4, 7, 17, 30).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 7, 20, 0).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),

                new Show(LocalDateTime.of(2016, 4, 8, 17, 30).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1"),
                new Show(LocalDateTime.of(2016, 4, 8, 20, 0).plusMinutes(offset), BigDecimal.valueOf(7.50), "Saal 1")
        );
    }

    

    private Room createRoom() {
        return new Room("Pali", 
                "   XXXXXXXXXXXXX     \n" +
                        "  XXXXXXXXXXXXXXXXX  \n" +
                        " XXXXXXXXXXXXXXXXXXX \n" +
                        "XXXXXXXXXXXXXXXXXXXXX\n" +
                        "XXXXXXXXXXXXXXXXXXXXX\n" +
                        "XXXXXXXXXXXXXXXXXXXXX\n");
    }
}
