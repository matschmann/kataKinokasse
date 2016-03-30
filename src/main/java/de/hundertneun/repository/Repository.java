package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.util.List;

public interface Repository {

    List<Movie> listMovies();

    List<Show> listShows(Movie movie);
    
    boolean reserveSeat(Show show, int seatNumber);
    
    boolean isSeatAvailable(Show show, int seatNumber);
    
    List<Seat> listAvaliableSeats(Show show); 
    
}
