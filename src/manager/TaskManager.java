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

    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, SubTask> subTasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();


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
    public void addTask(SubTask task) {
        subTasks.put(task.getID(), task);
    }

    //создание и добавление подзадач в список для эпика
    public ArrayList<SubTask> addSubTask(SubTask subTask, ArrayList<SubTask> subTasks) {
        if (!subTasks.contains(subTask)) {
            subTasks.add(subTask);
        }
        return subTasks;
    }

    //добавление эпика
    public void addTask(Epic epic) {
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


    public void countEpicStatus(Epic epic) {

        int newStatus = 0;
        int doneStatus = 0;
        for (SubTask s : epic.getSubTasks()) {
            if (s.getStatus() == Status.DONE) {
                doneStatus++;
            } else {
                newStatus++;
            }

            if (doneStatus > newStatus && newStatus == 0) {
                epic.setStatus(Status.DONE);
            } else if (newStatus > doneStatus && doneStatus == 0) {
                epic.setStatus(Status.NEW);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
        epics.put(epic.getID(), epic);
    }


    //очистка списка задач
    public HashMap clearTaskList() {
        tasks.clear();
        return tasks;
    }

    //очистка списка подзадач
    public HashMap clearSubTaskList() {
        subTasks.clear();
        return subTasks;
    }

    //очистка листа эпиков
    public HashMap clearEpicList() {
        epics.clear();
        return epics;
    }

    public List getTaskList() {
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasks.values()) {
            taskList.add(tasks.get(task.getID()));
        }
        return taskList;
    }

    public List getSubTaskList() {
        List<SubTask> taskList = new ArrayList<>();
        for (SubTask subTask : subTasks.values()) {
            taskList.add(subTasks.get(subTask.getID()));
        }
        return taskList;
    }


    public List getEpicList() {
        List<Epic> taskList = new ArrayList<>();
        for (Epic epic : epics.values()) {
            taskList.add(epics.get(epic.getID()));
        }
        return taskList;
    }


    public void epicList(HashMap<Integer, Epic> tasks) {
        System.out.println(tasks.values().toString());
    }

    public void subTaskList(HashMap<Integer, SubTask> tasks) {
        System.out.println(tasks.values().toString());
    }

    public Task getTaskById(HashMap<Integer, Task> tasks, int id) {
        return tasks.get(id);
    }

    public SubTask getSubTaskById(HashMap<Integer, SubTask> tasks, int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(HashMap<Integer, Epic> tasks, int id) {
        return tasks.get(id);
    }

    public void removeTaskByID(int id) {
        tasks.remove(id);
    }

    public void removeSubTaskByID(int id) {
        subTasks.remove(id);
    }

    public void removeEpicByID(int id) {
        epics.remove(id);
    }

}

