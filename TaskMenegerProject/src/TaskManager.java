import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {
    public static int taskCount = 1;

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        HashMap<Integer, Task> tasks = new HashMap<>();
        HashMap<Integer, SubTask> subTasks = new HashMap<>();
        HashMap<Integer, Epic> epics = new HashMap<>();

    }

    //добавление задачи
    public void addTask(HashMap<Integer, Task> tasks, Task task) {
        tasks.put(hashCode(task.getiD()), task);
    }

    //обновление задачи
    public void updateTask(HashMap<Integer, Task> tasks, Task task) {
        if (!tasks.containsKey(hashCode(task.getiD()))) {
            tasks.put(hashCode(task.getiD()), task);
        }
    }

    //добавление подзадачи в список менеджера
    public void addTask(HashMap<Integer, SubTask> tasks, SubTask task) {
        tasks.put(task.getiD(), task);
    }

    //создание и добавление подзадач в список для эпика
    ArrayList<SubTask> addSubTask(SubTask subTask, ArrayList<SubTask> subTasks) {
        if (!subTasks.contains(subTask)) {
            subTasks.add(subTask);
        }
        return subTasks;
    }

    //добавление эпика
    public void addTask(HashMap<Integer, Epic> tasks, Epic epic) {
        tasks.put(epic.getiD(), epic);
    }

    //обновление эпика
    public void updateTask(HashMap<Integer, Epic> tasks, Epic epic) {
        for (SubTask s : epic.subTasks) {
            if (s.getStatus() == Status.DONE) {
                epic.setStatus(Status.DONE);
            } else if (s.getStatus() == Status.NEW) {
                epic.setStatus(Status.NEW);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
        tasks.put(hashCode(epic.getiD()), epic);
    }

    //очистка списка
    public HashMap clearAll(HashMap hashMap) {
        hashMap.clear();
        return hashMap;
    }


    public void taskList(HashMap<Integer,Task> tasks) {
            System.out.println(tasks.values().toString());
    }

    public void epicList(HashMap<Integer,Epic> tasks) {
            System.out.println(tasks.values().toString());
    }

    public void subTaskList(HashMap<Integer,SubTask> tasks) {
        System.out.println(tasks.values().toString());
    }

    public Task getTaskById(HashMap<Integer, Task> tasks, int id) {
        return tasks.get(id);
    }

    public SubTask getSubTaskById(HashMap<Integer,SubTask> tasks, int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(HashMap<Integer,Epic> tasks, int id) {
        return tasks.get(id);
    }

    public HashMap removeTaskByID(HashMap<Integer,Task> tasks, int id) {
        tasks.remove(id);
        return tasks;
    }

    public HashMap removeSubTaskByID(HashMap<Integer,SubTask> tasks, int id) {
        tasks.remove(id);
        return tasks;
    }

    public HashMap removeEpicTaskByID(HashMap<Integer,Epic> tasks, int id) {
        tasks.remove(id);
        return tasks;
    }

    Integer hashCode(Object o) {
        return Objects.hash(o);
    }
}

