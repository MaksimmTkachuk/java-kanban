package manager;

import task.Task;

import java.util.List;

public interface HistoryManager {
    //добавление в историю
    void add(Task task);

    //список истории
    List<Task> getHistory();
}
