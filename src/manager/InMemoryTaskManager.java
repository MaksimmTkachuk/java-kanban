package manager;

import task.Epic;
import task.Status;
import task.SubTask;
import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static manager.Managers.getDefaultHistory;
import static manager.InMemoryHistoryManager.history;

public class InMemoryTaskManager implements TaskManager, HistoryManager {
    public static int idCounter = 1;

    HistoryManager historyManager = getDefaultHistory();


    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();

    //добавление задачи
    @Override
    public void addTask(Task task) {
        tasks.put(task.getID(), task);
    }

    //обновление задачи
    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            tasks.put(task.getID(), task);
        }
    }

    //добавление подзадачи в список менеджера
    @Override
    public void addSubTask(SubTask task) {
        subTasks.put(task.getID(), task);
    }

    //обновление подзадачи
    @Override
    public void updateSubTask(SubTask task) {
        if (subTasks.containsKey(task.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            subTasks.put(task.getID(), task);
        }
    }

    //добавление одной позадачи в эпик
    @Override
    public boolean addSingleSubTaskToEpic(Task subTask, Epic epic) {
        if(subTask instanceof Epic && subTask == this) {
            return false;
        } else {
            epic.setSubTask((SubTask) subTask);
        }
       return true;
    }

    //создание и добавление подзадач в список для эпика
    @Override
    public boolean addSubTaskToEpic(Task subTask, ArrayList<SubTask> subTasks) {
        if (subTask == this) {
            return false;
        } else {
            if (!subTasks.contains((SubTask) subTask)) {
                subTasks.add((SubTask) subTask);
            }
        }
        return true;
    }

    @Override
    public void removeSubTaskFromEpic(SubTask subTask, ArrayList<SubTask> subTasks) {
        subTasks.remove(subTask);
    }

    //добавление эпика
    @Override
    public void addEpic(Epic epic) {
        epics.put(epic.getID(), epic);
    }

    //обновление эпика
    @Override
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getID())) {
            System.out.println("Такая задача уже добавлена.");
        } else {
            tasks.put(epic.getID(), epic);
        }
    }

    @Override
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

    @Override
    public boolean add(Task task) {
        return true;
    }

    //список истории
    @Override
    public List<Task> getHistory() {
        return history;
    }


    @Override
    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public HashMap<Integer, SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    //очистка списка задач
    @Override
    public void clearTaskList() {
        tasks.clear();
    }

    //очистка списка подзадач
    @Override
    public void clearSubTaskList() {
        subTasks.clear();
    }

    //очистка листа эпиков
    @Override
    public void clearEpicList() {
        epics.clear();
    }

    //получение списка задач
    @Override
    public List<Task> getTaskList() {
        return new ArrayList<Task>(tasks.values());
    }

    //получение списка подзадач
    @Override
    public List<SubTask> getSubTaskList() {
        return new ArrayList<>(subTasks.values());
    }

    //получение списка эпиков
    @Override
    public List<Epic> getEpicList() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public List<SubTask> getEpicSubtasks(int id) {

        return new ArrayList<SubTask>(epics.get(id).getSubTasksToEpicList());
    }

    //получение задачи по номеру
    @Override
    public Task getTaskById(int id) {
        Task task = tasks.get(id);

        if (task != null) {
            if (history.size() == 10) {
                history.removeFirst();
                history.addFirst(task);
            } else {
                history.add(task);
            }
        }
        return tasks.get(id);
    }

    //получение подзадачи по номеру
    @Override
    public SubTask getSubTaskById(int id) {
        SubTask task = subTasks.get(id);

        if (task != null) {
            if (history.size() == 10) {
                history.removeFirst();
                history.addFirst(task);
            } else {
                history.add(task);
            }
        }
        return subTasks.get(id);
    }

    //получение эпика по номеру
    @Override
    public Epic getEpicById(int id) {
        Epic task = epics.get(id);

        if (task != null) {
            if (history.size() == 10) {
                history.removeFirst();
                history.addFirst(task);
            } else {
                history.add(task);
            }
        }
        return epics.get(id);
    }

    //удаление задачи по номеру
    @Override
    public void removeTaskByID(int id) {
        tasks.remove(id);
    }

    //удаление подзадачи по номеру
    @Override
    public void removeSubTaskByID(int id) {
        subTasks.remove(id);
    }

    //удаление эпика по номеру
    @Override
    public void removeEpicByID(int id) {
        epics.remove(id);
    }
}

