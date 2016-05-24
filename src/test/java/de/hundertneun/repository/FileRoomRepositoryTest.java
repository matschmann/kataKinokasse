package de.hundertneun.repository;

import de.hundertneun.repository.FileRoomRepository;
import de.hundertneun.vo.Room;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Optional;

public class FileRoomRepositoryTest {

    @Test
    public void getRoomByName() throws Exception {
        FileRoomRepository fileRoomRepository = new FileRoomRepository(Paths.get("data/rooms"));

        Optional<Room> roomByName = fileRoomRepository.getRoomByName("Saal 1");

        assertThat(roomByName).isPresent();
        assertThat(roomByName.get().getTotalNumberOfSeats()).isEqualTo(112);

    }

    @Test
    public void testGetRoomByName() throws Exception {
        FileRoomRepository fileRoomRepository = new FileRoomRepository(Paths.get("data/rooms"));

        Optional<Room> roomByName = fileRoomRepository.getRoomByName("Rumpelkammer");

        
        assertThat(roomByName).isNotPresent();

    }
}