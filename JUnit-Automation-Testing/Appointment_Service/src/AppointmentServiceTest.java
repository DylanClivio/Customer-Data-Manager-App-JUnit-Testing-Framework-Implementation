import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 100000);
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("12345"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("12345", futureDate, "Description 1");
        Appointment appointment2 = new Appointment("12345", futureDate, "Description 2");
        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("12345");
        assertNull(appointmentService.getAppointment("12345"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("12345");
        });
    }
}