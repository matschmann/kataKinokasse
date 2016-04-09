package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextfileRepository implements Repository {

    private List<Movie> movies = new ArrayList<>();
    
    public TextfileRepository(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = in.readLine()) != null) {
            String movieTitle = line.split(";")[0];
            movies.add(new Movie(movieTitle));
        }
    }

    @Override
    public List<Movie> listMovies() {
        return movies;
    }

    @Override
    public List<Show> listShows(Movie movie) {
        return null;
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
