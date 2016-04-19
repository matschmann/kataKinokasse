package de.hundertneun.repository;

import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.util.List;
import java.util.UUID;

public interface Repository {

    List<Movie> listMovies();

    List<Show> listShowsByMovie(UUID movieId);
    
    boolean reserveSeat(UUID showId, int seatNumber);
    
    boolean isSeatAvailable(UUID showId, int seatNumber);
    
    List<Seat> listAvaliableSeats(UUID showId); 
    
}
