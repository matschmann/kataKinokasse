package de.hundertneun.vo;

import de.hundertneun.webservice.LocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Show {

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateTime;
    
    private BigDecimal price; 
    
    private String roomName;
    private UUID id;
    private Movie movie;

    public Show() {
    }

    public Show(LocalDateTime dateTime, BigDecimal price, String roomName) {
        this.dateTime = dateTime;
        this.price = price;
        this.roomName = roomName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Show{" +
                "dateTime=" + dateTime +
                ", price=" + price +
                ", roomName='" + roomName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Show show = (Show) o;

        return dateTime != null ? dateTime.equals(show.dateTime) : show.dateTime == null &&
                price != null ? price.compareTo(show.price) == 0 : show.price == null &&
                roomName != null ? roomName.equals(show.roomName) : show.roomName == null;

    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        return result;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
