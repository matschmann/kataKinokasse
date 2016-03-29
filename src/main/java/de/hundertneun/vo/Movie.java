package de.hundertneun.vo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class Movie {
    private String title;
    private List<Date> dates;
    private SeatingPlan seatingPlan;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }


    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }

    public void setSeatingPlan(SeatingPlan seatingPlan) {
        this.seatingPlan = seatingPlan;
    }
}
