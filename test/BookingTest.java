import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.sql.SQLException;

public class BookingTest {

    @Test
    public void testBusAvailabilityWhenFull() throws SQLException {
        BookingDAO dao = new BookingDAO();

        // Scenario: Bus 101 has capacity 2. 
        // We check availability for a date where 2 people are already booked.
        Date travelDate = Date.valueOf("2026-05-10");

        boolean result = dao.isAvailable(101, travelDate);

        // Assert: We expect 'false' if the bus is actually full in the DB
        assertFalse(result, "Bus should be full but returned available");
    }

    @Test
    public void testValidDateInput() {
        // Test if our date parser handles leap years or invalid formats
        String leapYearDate = "2024-02-29";
        assertDoesNotThrow(() -> Date.valueOf(leapYearDate));
    }
}