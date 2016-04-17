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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockRepository implements Repository {

    public static final String TITLE1 = "Der Stadtneurotiker";
    public static final String TITLE2 = "Alice";
    public static final String TITLE3 = "Hollywood Ending";
    public static final String TITLE4 = "Harry außer sich";
    
    private final Map<String, Movie> movies;

    public MockRepository() {
        movies = new HashMap<>();
        movies.put(TITLE1, new Movie(TITLE1));
        movies.put(TITLE2, new Movie(TITLE2));
        movies.put(TITLE3, new Movie(TITLE3));
        movies.put(TITLE4, new Movie(TITLE4));
    }


    @Override
    public List<Movie> listMovies() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public List<Show> listShows(Movie movie) {
        switch (movie.getTitle()) {
            case TITLE1:
                return createDates(0);
            case TITLE2:
                return createDates(-15);
            case TITLE3:
                return createDates(30);
            case TITLE4:
                return createDates(-30);
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public boolean reserveSeat(Show show, int seatNumber) {
        return false;
    }

    @Override
    public boolean isSeatAvailable(Show show, int seatNumber) {
        return false;
    }

    @Override
    public List<Seat> listAvaliableSeats(Show show) {
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
