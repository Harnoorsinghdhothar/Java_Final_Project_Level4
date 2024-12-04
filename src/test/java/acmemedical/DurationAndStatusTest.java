package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DurationAndStatusTest {

    private DurationAndStatus durationAndStatus1;
    private DurationAndStatus durationAndStatus2;

    @BeforeEach
    void setUp() {
        durationAndStatus1 = new DurationAndStatus();
        durationAndStatus2 = new DurationAndStatus();

        LocalDateTime startDate = LocalDateTime.of(2024, 12, 1, 10, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 10, 18, 0);

        durationAndStatus1.setStartDate(startDate);
        durationAndStatus1.setEndDate(endDate);
        durationAndStatus1.setActive((byte) 1);

        durationAndStatus2.setStartDate(startDate);
        durationAndStatus2.setEndDate(endDate);
        durationAndStatus2.setActive((byte) 1);
    }

    @Test
    void testSetEndDate() {
        LocalDateTime newEndDate = LocalDateTime.of(2024, 12, 15, 18, 0);
        durationAndStatus1.setEndDate(newEndDate);
        assertEquals(newEndDate, durationAndStatus1.getEndDate());
    }

    @Test
    void testGetActive() {
        assertEquals((byte) 1, durationAndStatus1.getActive());
    }

    @Test
    void testSetActive() {
        durationAndStatus1.setActive((byte) 0);
        assertEquals((byte) 0, durationAndStatus1.getActive());
    }

    @Test
    void testSetDurationAndStatus() {
        LocalDateTime startDate = LocalDateTime.of(2024, 12, 20, 9, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 25, 17, 0);
        durationAndStatus1.setDurationAndStatus(startDate, endDate, "+");
        assertEquals(startDate, durationAndStatus1.getStartDate());
        assertEquals(endDate, durationAndStatus1.getEndDate());
        assertEquals((byte) 1, durationAndStatus1.getActive());
    }

   
    @Test
    void testEqualsObject() {
        assertEquals(durationAndStatus1, durationAndStatus2);

        durationAndStatus2.setActive((byte) 0);
        assertNotEquals(durationAndStatus1, durationAndStatus2);
    }
}
