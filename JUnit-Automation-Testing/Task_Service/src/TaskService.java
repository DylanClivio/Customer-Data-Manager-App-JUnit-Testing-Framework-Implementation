import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    public boolean addTask(String taskId, String name, String description) {
        if (tasks.containsKey(taskId)) {
            return false;
        }
        Task newTask = new Task(taskId, name, description);
        tasks.put(taskId, newTask);
        return true;
    }

    public boolean deleteTask(String taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }

    public boolean updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setName(newName);
            return true;
        }
        return false;
    }

    public boolean updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setDescription(newDescription);
            return true;
        }
        return false;
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}