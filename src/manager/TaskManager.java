package manager;

import task.Epic;
import task.SubTask;
import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {
    //добавление задачи
    void addTask(Task task);

    //обновление задачи
    void updateTask(Task task);

    //добавление подзадачи в список менеджера
    void addSubTask(SubTask task);

    //обновление подзадачи
    void updateSubTask(SubTask task);

    //создание и добавление подзадач в список для эпика
    boolean addSubTaskToEpic(Task subTask, ArrayList<SubTask> subTasks);

    void removeSubTaskFromEpic(SubTask subTask, ArrayList<SubTask> subTasks);

    //добавление эпика
    void addEpic(Epic epic);

    //обновление эпика
    void updateEpic(Epic epic);

    void updateEpicStatus(int id);

    HashMap<Integer, Task> getTasks();

    HashMap<Integer, SubTask> getSubTasks();

    HashMap<Integer, Epic> getEpics();

    //отображение истории
    List<Task> getHistory();

    //очистка списка задач
    void clearTaskList();

    //очистка списка подзадач
    void clearSubTaskList();

    //очистка листа эпиков
    void clearEpicList();

    //получение списка задач
    List<Task> getTaskList();

    //получение списка подзадач
    List<SubTask> getSubTaskList();

    //получение списка эпиков
    List<Epic> getEpicList();

    List<SubTask> getEpicSubtasks(int id);

    //получение задачи по номеру
    Task getTaskById(int id);

    //получение подзадачи по номеру
    SubTask getSubTaskById(int id);

    //получение эпика по номеру
    Epic getEpicById(int id);

    //удаление задачи по номеру
    void removeTaskByID(int id);

    //удаление подзадачи по номеру
    void removeSubTaskByID(int id);

    //удаление эпика по номеру
    void removeEpicByID(int id);

}
