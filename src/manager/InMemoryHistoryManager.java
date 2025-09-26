package manager;


import task.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public static List<Task> history = new ArrayList<>(10);


    @Override
    public boolean add(Task task) {
        return true;
    }

    //истороия просмотров
    @Override
    public List<Task> getHistory() {
        return history;
    }
}
