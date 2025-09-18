import java.util.ArrayList;
import java.util.HashMap;

public class SubTask extends Task {

    SubTask(String title, String description, int taskCount, Status status) {
        super(title, description, taskCount, status);
    }

    @Override
    public String toString() {
        return "SubTask{}";
    }

    // Метод для добавленя подзадач для одного эпика в единый список для эпика


    public int hashCode() {
        return Integer.hashCode(getiD());
    }
}


