public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID can't be null and can be up to 10 characters long");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name can't be null and can be up to 20 characters long");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description can't be null and can be up to 50 characters long");
        }
        
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name can't be null and can be up to 20 characters long");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description can't be null and can be up to 50 characters long");
        }
        this.description = description;
    }
}