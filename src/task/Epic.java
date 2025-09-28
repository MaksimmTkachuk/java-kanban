package task;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<SubTask> subTasksToEpicList;


    public Epic(String title, String description, int idCounter, Status status) {
        super(title, description, idCounter, status);
        this.subTasksToEpicList = getSubTasksToEpicList();
    }

    public ArrayList<SubTask>  getSubTasksToEpicList() {
        return subTasksToEpicList;
    }

    public boolean setSubTasks(Task epic, ArrayList<SubTask> subTasks) {
        if (epic instanceof Epic) {
            ((Epic) epic).subTasksToEpicList = subTasks;
            return true; }

        return false;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subTasks=" + subTasksToEpicList +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID=" + getID() +
                ", status=" + getStatus() +
                '}';
    }

}



