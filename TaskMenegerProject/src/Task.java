import java.util.Objects;

public class Task extends TaskManager {
    private String title;
    private String description;
    private int iD;
    private Status status;


    Task(String title, String descript, int taskCount, Status status) {
        this.title = title;
        this.description = descript;
        this.iD = taskCount++;
        this.status = status;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // можно оформить и так
        Task otherTask = (Task) obj;
        return Objects.equals(title, otherTask.title) &&
                Objects.equals(description, otherTask.description) &&
                (iD == otherTask.iD) && Objects.equals(status, otherTask.status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", descript='" + description + '\'' +
                ", iD=" + iD +
                ", status=" + status +
                '}';
    }


    @Override
    public int hashCode() {
        return Integer.hashCode(iD);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
