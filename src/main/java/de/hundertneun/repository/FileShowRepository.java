package de.hundertneun.repository;

import de.hundertneun.util.DateUtil;
import de.hundertneun.vo.Movie;
import de.hundertneun.vo.Room;
import de.hundertneun.vo.Seat;
import de.hundertneun.vo.Show;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class FileShowRepository implements ShowRepository {

    private final Map<UUID, Show> shows = new HashMap<>();
    private RoomRepository roomRepository = new FileRoomRepository(Paths.get("data/rooms"));
    
    public FileShowRepository(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split(";");
            readShows(new Movie(split[0]), split[1]);
        }
    }

    private void readShows(Movie movie, String showList) {
        //showList is a string like 
        //   Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00,...
        
        for (String singleShow : showList.split(",")) {
            String[] split = singleShow.split("/");

            Show show = new Show();
            show.setId(UUID.randomUUID());
            show.setDateTime(getDateTime(split[0], split[1]));
            show.setRoomName(split[2]);
            show.setPrice(new BigDecimal(split[3]));
            show.setMovie(movie);

            this.shows.put(show.getId(), show);
        }
    }

    private LocalDateTime getDateTime(String day, String time) {
        LocalDate dateOfShow = DateUtil.nextDayOfWeek(DateUtil.parseDay(day), LocalDate.now());
        LocalTime timeOfShow = DateUtil.parseTime(time);
        return dateOfShow.atTime(timeOfShow);
    }

    @Override
    public List<Movie> listMovies() {
        Set<Movie> movies = new HashSet<>();
        for (Show show : shows.values()) {
            movies.add(show.getMovie());
        }
        return new ArrayList<>(movies);
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
    public boolean reserveSeat(UUID showId, int seatNumber) {
        Optional<Room> roomByName = getRoom(showId);

        Seat seat = roomByName.get().getSeatByNumber(seatNumber);
        seat.setTaken(true);
        return !seat.isTaken();
    }

    @Override
    public boolean isSeatAvailable(UUID showId, int seatNumber) {
        return getRoom(showId).get().getSeatByNumber(seatNumber).isTaken();
    }

    @Override
    public List<Seat> listAvaliableSeats(UUID showId) {
        List<Seat> availableSeats = new ArrayList<>();
        
        Optional<Room> room = getRoom(showId);
        List<Seat> seats = room.get().getSeats();
        for (Seat seat : seats) {
            if (!seat.isTaken()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    private Optional<Room> getRoom(UUID showId) {
        Show show = shows.get(showId);
        return roomRepository.getRoomByName(show.getRoomName());
    }
}
