package de.hundertneun.vo;

import java.util.UUID;

public class Movie {
    private String title;
    private UUID uuid;

    public Movie(String title) {
        assert title != null;
        
        this.title = title;

        uuid = UUID.nameUUIDFromBytes(title.getBytes());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public UUID getId() {

        return uuid;
    }
}
