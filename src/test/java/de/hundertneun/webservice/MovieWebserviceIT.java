package de.hundertneun.webservice;

import de.hundertneun.repository.MockShowRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;


public class MovieWebserviceIT {

    
    @Test
    public void allMovies() {
        String jsonRespone = requestForPath("movies");
        
        //check if all titles exit
        assertThat(jsonRespone).contains(
                MockShowRepository.MOVIE1.getTitle(),
                MockShowRepository.MOVIE2.getTitle(),
                MockShowRepository.MOVIE3.getTitle(),
                MockShowRepository.MOVIE4.getTitle()
        );
    }

    @Test
    public void shows_validMovieName_returnsAllMovieShows() throws Exception {
        String jsonRespone = requestForPath("shows/" + MockShowRepository.MOVIE4.getTitle());
        
        //check if result contains at leat one date in the correct format
        assertThat(jsonRespone).matches(".*\"\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}\".*");
    }

    @Test
    public void shows_invalidMovieName_returnsNOT_FOUND() throws Exception {
        assertThatThrownBy(() -> requestForPath("shows/nonexisting")).isInstanceOf(RuntimeException.class);
    }


    private String requestForPath(String movies) {
        String jsonRespone = "";//target.path(movies).request().get(String.class);
        System.out.println(jsonRespone);
        return jsonRespone;
    }
}