package de.hundertneun.vo;

import de.hundertneun.webservice.LocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Show {

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateTime;
    
    private BigDecimal price; 
    
    private String room;

    public Show() {
    }

    public Show(LocalDateTime dateTime, BigDecimal price, String room) {
        this.dateTime = dateTime;
        this.price = price;
        this.room = room;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Show{" +
                "dateTime=" + dateTime +
                ", price=" + price +
                ", room='" + room + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Show show = (Show) o;

        return dateTime != null ? dateTime.equals(show.dateTime) : show.dateTime == null &&
                price != null ? price.compareTo(show.price) == 0 : show.price == null &&
                room != null ? room.equals(show.room) : show.room == null;

    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }
}
