package de.hundertneun.vo;

import de.hundertneun.vo.Room;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class RoomTest {

    @Test
    public void getTotalNumberOfSeats() throws Exception {
        assertThat(createRoom().getTotalNumberOfSeats()).isEqualTo(112);
    } 
    
    @Test
    public void getByNumber_exists() throws Exception {
        assertThat(createRoom().getSeatByNumber(12)).isNotNull();
        assertThat(createRoom().getSeatByNumber(112)).isNotNull();
    } 
    
    @Test
    public void getByNumber_tooSmall_throwsIllegalArgumentException() throws Exception {
        assertThatThrownBy(() -> createRoom().getSeatByNumber(0)).isInstanceOf(IllegalArgumentException.class);

    } 
    
    @Test
    public void getByNumber_tooLarge_throwsIllegalArgumentException() throws Exception {
        assertThatThrownBy(() -> createRoom().getSeatByNumber(113)).isInstanceOf(IllegalArgumentException.class);

    }

    private Room createRoom() {
        return new Room("Helia 1", 
                            "    XXXXXXXXXXXXX    \n" + 
                            "  XXXXXXXXXXXXXXXXX  \n" + 
                            " XXXXXXXXXXXXXXXXXXX \n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n");
    }
}