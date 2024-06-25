import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is too long and should cause an exception to be thrown by the constructor.");
        });
    }
}