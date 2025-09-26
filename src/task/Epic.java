package task;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<SubTask> subTasksToEpicList;
    private SubTask subTask;

    public Epic(String title, String description, int idCounter, Status status) {
        super(title, description, idCounter, status);
        this.subTasksToEpicList = getSubTasksToEpicList();
        this.subTask = getSubTask();
    }

    public SubTask getSubTask() {
        return subTask;
    }

    public void setSubTask(Task subTask) {
        this.subTask = (SubTask) subTask;
    }

    public ArrayList<SubTask> getSubTasksToEpicList() {
        return subTasksToEpicList;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasksToEpicList = subTasks;
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



