import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        assertTrue(taskService.addTask("1", "Task Name", "Task Description"));
        assertFalse(taskService.addTask("1", "Duplicate Task Name", "Duplicate Task Description"));
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("1", "Task Name", "Task Description");
        assertTrue(taskService.deleteTask("1"));
        assertFalse(taskService.deleteTask("1"));
    }

    @Test
    void testUpdateTaskName() {
        taskService.addTask("1", "Task Name", "Task Description");
        assertTrue(taskService.updateTaskName("1", "New Task Name"));
        assertEquals("New Task Name", taskService.getTask("1").getName());
        assertFalse(taskService.updateTaskName("2", "Non-existent Task Name"));
    }

    @Test
    void testUpdateTaskDescription() {
        taskService.addTask("1", "Task Name", "Task Description");
        assertTrue(taskService.updateTaskDescription("1", "New Task Description"));
        assertEquals("New Task Description", taskService.getTask("1").getDescription());
        assertFalse(taskService.updateTaskDescription("2", "Non-existent Task Description"));
    }
}