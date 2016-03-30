package de.hundertneun.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RoomTest {

    @Test
    public void getTotalNumberOfSeats() throws Exception {
        assertThat(seatingPlan().getTotalNumberOfSeats()).isEqualTo(112);
    } 
    
    @Test
    public void getByNumber_exists() throws Exception {
        assertThat(seatingPlan().getByNumber(12)).isNotNull();
        assertThat(seatingPlan().getByNumber(112)).isNotNull();
    } 
    
    @Test
    public void getByNumber_tooSmall_throwsIllegalArgumentException() throws Exception {
        assertThatThrownBy(() -> seatingPlan().getByNumber(0)).isInstanceOf(IllegalArgumentException.class);

    } 
    
    @Test
    public void getByNumber_tooLarge_throwsIllegalArgumentException() throws Exception {
        assertThatThrownBy(() -> seatingPlan().getByNumber(113)).isInstanceOf(IllegalArgumentException.class);

    }

    private Room seatingPlan() {
        return new Room("Helia 1", 
                            "    XXXXXXXXXXXXX    \n" + 
                            "  XXXXXXXXXXXXXXXXX  \n" + 
                            " XXXXXXXXXXXXXXXXXXX \n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n" + 
                            "XXXXXXXXXXXXXXXXXXXXX\n");
    }
}