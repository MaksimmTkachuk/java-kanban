package manager;

import task.Epic;
import task.Status;
import task.SubTask;
import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    public static int idCounter = 1;

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();

    //добавление задачи
    public void addTask(Task task) {
        tasks.put(task.getID(), task);
    }

    //обновление задачи
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            tasks.put(task.getID(), task);
        }
    }

    //добавление подзадачи в список менеджера
    public void addSubTask(SubTask task) {
        subTasks.put(task.getID(), task);
    }

    //обновление подзадачи
    public void updateSubTask(SubTask task) {
        if (subTasks.containsKey(task.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            subTasks.put(task.getID(), task);
        }
    }

    //создание и добавление подзадач в список для эпика
    public void addSubTaskToEpic(SubTask subTask, ArrayList<SubTask> subTasks) {
        if (!subTasks.contains(subTask)) subTasks.add(subTask);
    }

    public void removeSubTaskFromEpic(SubTask subTask, ArrayList<SubTask> subTasks) {
        subTasks.remove(subTask);
    }

    //добавление эпика
    public void addEpic(Epic epic) {
        epics.put(epic.getID(), epic);
    }

    //обновление эпика
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            tasks.put(epic.getID(), epic);
        }
    }

    public void updateEpicStatus(int id) {

        int newStatus = 0;
        int doneStatus = 0;

        if (getEpicById(id) != null) {

            for (SubTask s : getEpicById(id).getSubTasksToEpicList()) {
                if (s.getStatus() == Status.DONE) {
                    doneStatus++;
                } else {
                    newStatus++;
                }

                if (doneStatus > newStatus && newStatus == 0) {
                    getEpicById(id).setStatus(Status.DONE);
                } else if (newStatus > doneStatus && doneStatus == 0) {
                    getEpicById(id).setStatus(Status.NEW);
                } else if (getEpicById(id).getSubTasks() == null) {
                    getEpicById(id).setStatus(Status.NEW);
                } else {
                    getEpicById(id).setStatus(Status.IN_PROGRESS);
                }
            }
        }
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public HashMap<Integer, SubTask> getSubTasks() {
        return subTasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    //очистка списка задач
    public void clearTaskList() {
        tasks.clear();
    }

    //очистка списка подзадач
    public void clearSubTaskList() {
        subTasks.clear();
    }

    //очистка листа эпиков
    public void clearEpicList() {
        epics.clear();
    }

    //получение списка задач
    public List getTaskList() {
        return new ArrayList<>(tasks.values());
    }

    //получение списка подзадач
    public List getSubTaskList() {
        return new ArrayList<>(subTasks.values());
    }

    //получение списка эпиков
    public List getEpicList() {
        return new ArrayList<>(epics.values());
    }

    //получение задачи по номеру
    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    //получение подзадачи по номеру
    public SubTask getSubTaskById(int id) {
        return subTasks.get(id);
    }

    //получение эпика по номеру
    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    //удаление задачи по номеру
    public void removeTaskByID(int id) {
        tasks.remove(id);
    }

    //удаление подзадачи по номеру
    public void removeSubTaskByID(int id) {
        subTasks.remove(id);
    }

    //удаление эпика по номеру
    public void removeEpicByID(int id) {
        epics.remove(id);
    }
}

