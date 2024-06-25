import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("1", "Task Name", "Task Description");
        assertEquals("1", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testTaskIdValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
    }

    @Test
    void testTaskNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name that is too long for this task", "Description"));
    }

    @Test
    void testTaskDescriptionValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", "Description that is too long for this task to handle within the constraints"));
    }

    @Test
    void testSetName() {
        Task task = new Task("1", "Task Name", "Task Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("Name that is too long for this task"));
    }

    @Test
    void testSetDescription() {
        Task task = new Task("1", "Task Name", "Task Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("Description that is too long to handle within the constraints"));
    }
}