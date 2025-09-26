package manager;

import task.Task;

import java.util.List;

public interface HistoryManager {
    boolean add(Task task);

    //список истории
    List<Task> getHistory();
}
