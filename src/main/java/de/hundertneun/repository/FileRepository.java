package de.hundertneun.repository;

import de.hundertneun.App;
import de.hundertneun.util.DateUtil;
import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FileRepository implements Repository {

    private final Map<UUID, Show> shows = new HashMap<>();
    private final List<Movie> movies = new ArrayList<>();
    
    public FileRepository(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split(";");
            Movie movie = readMovie(split[0]);
            readShows(split[1], movie);
        }
    }

    private Movie readMovie(String movieTitle) {
        Movie movie = new Movie(movieTitle);
        movies.add(movie);
        return movie; 
    }

    private void readShows(String showList, Movie movie) {
        //showList is a string like 
        //   Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00,...
        
        for (String singleShow : showList.split(",")) {
            String[] split = singleShow.split("/");

            Show show = new Show();
            show.setId(UUID.randomUUID());
            show.setDateTime(getDateTime(split[0], split[1]));
            show.setRoom(split[2]);
            show.setPrice(new BigDecimal(split[3]));
            show.setMovie(movie);

            this.shows.put(show.getId(), show);
        }
    }

    private LocalDateTime getDateTime(String day, String time) {
        LocalDate dateOfShow = DateUtil.nextDayOfWeek(DateUtil.parseDay(day), App.CURRENT_DATE_TIME.toLocalDate());
        LocalTime timeOfShow = DateUtil.parseTime(time);
        return dateOfShow.atTime(timeOfShow);
    }

    @Override
    public List<Movie> listMovies() {
        return movies;
    }

    @Override
    public List<Show> listShowsByMovie(UUID movieId) {
        List<Show> showsByMovie = new ArrayList<>();
        for (Show show : shows.values()) { //TODO java8
            if (show.getMovie().getId().equals(movieId)) {
                showsByMovie.add(show);
            }
        }
        return showsByMovie;
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
}
