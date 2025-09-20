package task;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks;


    public Epic(String title, String description, int idCounter, Status status, ArrayList<SubTask> subTasks) {
        super(title, description, idCounter, status);
        this.subTasks = subTasks;
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subTasks=" + subTasks +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID=" + getID() +
                ", status=" + getStatus() +
                '}';
    }

}



