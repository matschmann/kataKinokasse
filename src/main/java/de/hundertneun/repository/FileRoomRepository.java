package de.hundertneun.repository;

import de.hundertneun.vo.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class FileRoomRepository implements RoomRepository {


    private final Path roomDirectory;

    public FileRoomRepository(Path roomDirectory) {
        this.roomDirectory = roomDirectory;
        assert Files.isDirectory(roomDirectory);


    }

    @Override
    public Optional<Room> getRoomByName(String name) {
        try {

            return Files.list(roomDirectory)
                    .filter(path -> path.getFileName().toString().equals(name + ".txt"))
                    .map(path -> {
                        try {
                            return new Room(name, new String(Files.readAllBytes(path)));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .findAny();
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private void roomList() throws IOException {

    }
}
