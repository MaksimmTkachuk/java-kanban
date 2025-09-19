import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {
    ArrayList<SubTask> subTasks;

    Epic(String title, String description, int taskCount, Status status, ArrayList<SubTask> subTasks) {
        super(title, description, taskCount, status);
        this.subTasks = subTasks;
    }



    @Override
    public String toString() {
        return "Epic{" +
                "subTasks=" + subTasks +
                ", title='" + getTitle() + '\'' +
                ", descript='" + getDescription() + '\'' +
                ", iD=" + getiD() +
                ", status=" + getStatus() +
                '}';
    }

    public int hashCode() {
        return Integer.hashCode(getiD());
    }
}



