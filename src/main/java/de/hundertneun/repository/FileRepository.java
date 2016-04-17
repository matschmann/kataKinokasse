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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements Repository {

    private final List<Show> shows = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    
    public FileRepository(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = in.readLine()) != null) {
            String[] split1 = line.split(";");
            String movieTitle = split1[0];
            movies.add(new Movie(movieTitle));

            readShows(split1[1]);
        }
    }

    private void readShows(String showList) {
        //showList is a string like 
        //   Mo/17:00/Saal 1/7.00,Mo/20:00/Saal 1/8.00,...
        
        for (String singleShow : showList.split(",")) {
            String[] split = singleShow.split("/");

            String day = split[0];
            String time = split[1];
            String room = split[2];
            String price = split[3];

            Show ding = new Show();
            ding.setPrice(new BigDecimal(price));
            ding.setRoom(room);

            LocalDate dateOfShow = DateUtil.nextDayOfWeek(DateUtil.parseDay(day), App.CURRENT_DATE_TIME.toLocalDate());
            LocalTime timeOfShow = DateUtil.parseTime(time);
            
            ding.setDateTime(dateOfShow.atTime(timeOfShow));

            this.shows.add(ding);
        }
    }

    @Override
    public List<Movie> listMovies() {
        return movies;
    }

    @Override
    public List<Show> listShows(Movie movie) {
        return shows;
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
