package manager;


import task.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public static List<Task> history = new ArrayList<>(10);

    //добавление в историю
    @Override
    public void add(Task task) {
        if (task != null) {
            if (history.size() == 10) {
                history.removeFirst();
                history.addFirst(task);
            } else {
                history.add(task);
            }
        }
    }

    //истороия просмотров
    @Override
    public List<Task> getHistory() {
        return history;
    }
}
