package de.hundertneun.repository;

import de.hundertneun.vo.Room;

import java.util.Optional;

public interface RoomRepository {
    
    Optional<Room> getRoomByName(String name); 
}
