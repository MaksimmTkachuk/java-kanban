package task;

import manager.TaskManager;
import task.Status;

import java.util.Objects;

public class Task extends TaskManager {
    private String title;
    private String description;
    private int ID;
    private Status status;


    public Task(String title, String descript, int idCounter, Status status) {
        this.title = title;
        this.description = descript;
        this.ID = idCounter++;
        this.status = status;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // можно оформить и так
        Task otherTask = (Task) obj;
        return ID == otherTask.ID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", descript='" + description + '\'' +
                ", ID=" + ID +
                ", status=" + status +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(ID);
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
