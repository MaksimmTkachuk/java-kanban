package manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task.Epic;
import task.Status;
import task.SubTask;
import task.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    static TaskManager manager;
    static HistoryManager historyManager;

    @BeforeAll
    static void beforeAll() {
        manager = Managers.getDefault();
        historyManager = Managers.getDefaultHistory();
    }

    @Test
    void tasksIsEqualsIfEqualsID() {
        Task firstTask = new Task("firstTask", "firstTaskDescription", 1, Status.NEW);
        Task secondTask = new Task("secondTask", "secondTaskDescription", 1, Status.NEW);

        Assertions.assertEquals(firstTask, secondTask, "Если равны ID задач, то это должна быть одна задача");
    }

    @Test
    void subTasksIsEqualsIfEqualsID() {
        Task firstTask = new SubTask("firstTask", "firstTaskDescription", 1, Status.NEW);
        Task secondTask = new SubTask("secondTask", "secondTaskDescription", 1, Status.NEW);

        Assertions.assertEquals(firstTask, secondTask, "Если равны ID задач, то это должна быть одна задача");
    }

    @Test
    void EpicsIsEqualsIfEqualsID() {
        Task firstTask = new Epic("firstTask", "firstTaskDescription", 1, Status.NEW);
        Task secondTask = new Epic("secondTask", "secondTaskDescription", 1, Status.NEW);

        Assertions.assertEquals(firstTask, secondTask, "Если равны ID задач, то это должна быть одна задача");
    }

    @Test
    void epicCannotBeAddedToItself() {
        Task task = new Epic("epic", "epicDescription", 1, Status.NEW);
        ArrayList<SubTask> subTasksToEpic = new ArrayList<>();
        assertFalse(manager.addSubTaskToEpic(task, subTasksToEpic), "Эпик не может быть добавлен сам в себя");
    }

//    @Test
//    void subTaskCannotBeEpicToItself() {
//        SubTask task = new SubTask("task", "task description", 1, Status.NEW);
//        Epic epic = new Epic("epic", "epic description", 1, Status.NEW);
//        epic.setSubTask(task);
//
//        assertNull(task.setSubTask(task));
//
//    }

    @Test
    void managerClassGetWorkedManagers() {
        TaskManager manager1 = Managers.getDefault();
        HistoryManager manager2 = Managers.getDefaultHistory();

        assertEquals(new InMemoryTaskManager(), manager1, "Менеджеры должны быть новыми и проинициализированными");
        assertEquals(new InMemoryHistoryManager(), manager2, "Менеджеры должны быть новыми и проинициализированными");
    }

    @Test
    void InMemoryTaskManagerReallyAddAndFindTasksByID() {
        Task task = new Task("task", "task description", 1, Status.NEW);
        SubTask subTask = new SubTask("firstTask", "firstTaskDescription", 1, Status.NEW);
        Epic epic = new Epic("secondTask", "secondTaskDescription", 1, Status.NEW);
        manager.addSingleSubTaskToEpic(subTask, epic);

        manager.addTask(task);
        manager.addSubTask(subTask);
        manager.addEpic(epic);

        assertEquals(manager.getTasks().get(task.getID()), task, "Добавленная и созданная задачи должны совпадать");
        assertEquals(manager.getSubTasks().get(subTask.getID()), subTask, "Добавленная и созданная задачи должны совпадать");
        assertEquals(manager.getEpics().get(epic.getID()), epic, "Добавленная и созданная задачи должны совпадать");

        assertEquals(manager.getTaskById(task.getID()), task, "Метод должен отыскать задачу по ID");
        assertEquals(manager.getSubTaskById(subTask.getID()), subTask, "Метод должен отыскать задачу по ID");
        assertEquals(manager.getEpicById(epic.getID()), epic, "Метод должен отыскать задачу по ID");
    }

    @Test
    void taskWithSetIDAndWithHashIDDoNotConflictInManager() {
        Task task1 = new Task("task1", "task1 description", 1, Status.NEW);

        int code = 1;
        Task task2 = new Task("task2", "task2 description", code, Status.NEW);
        code = task2.hashCode();
        task2.setID(code);

        manager.addTask(task1);
        manager.addTask(task2);

        assertEquals(manager.getTasks().get(task1.getID()), task1, "Задача должна быть получена по установленному ID");
        assertEquals(manager.getTasks().get(task2.getID()), task2, "Задача должна быть получена по сгенерированному ID");
    }

    @Test
    void tasksNeedToBeEqualsByEveryFieldWhenItAddIntoManager() {
        Task task = new Task("task", "task description", 1, Status.NEW);

        manager.addTask(task);

        assertTrue(manager.getTasks().get(task.getID()).equals(task), "Объекты должны быть равны по всем полям");
    }

    @Test
    void tasksSavedAfterViewedInHistoryList() {
        Task task = new Task("task", "task description", 1, Status.NEW);

        manager.addTask(task);
        manager.getTaskById(task.getID());
        assertEquals(historyManager.getHistory().get(0), manager.getTasks().get(task.getID()), "Задача должна остаться той же после просмотра");
    }


}