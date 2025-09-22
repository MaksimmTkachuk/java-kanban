import manager.TaskManager;
import task.Epic;
import task.Status;
import task.SubTask;
import task.Task;

import java.util.ArrayList;

import static manager.TaskManager.idCounter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        Task study = new Task("Пройти спринт", "Успеть до жесткого дедлайна пройти 5й спринт", idCounter++, Status.NEW);
        Task work = new Task("Получить категорию", "Собрать все дипломы и прочую документацию", idCounter++, Status.NEW);

        Epic changePipe = new Epic("Заменить трубу", "Вырезать металлическую трубу и заменить ей гофру", idCounter++, Status.NEW);
        SubTask countLength = new SubTask("Замерить трубу", "Рассчитать рулеткой расстояние", idCounter++, Status.NEW);
        SubTask cleanWindows = new SubTask("Почистить окна", "Почистить окна для трубы", idCounter++, Status.NEW);
        ArrayList<SubTask> pipeChange = new ArrayList<>();
        taskManager.addSubTaskToEpic(countLength, pipeChange);
        taskManager.addSubTaskToEpic(cleanWindows, pipeChange);
        changePipe.setSubTasks(pipeChange);

        Epic writeQuartet = new Epic("Закончить квартет", "Закончить к ноябрю весь материал", idCounter++, Status.NEW);
        SubTask searchTheme = new SubTask("Найти вторую тему", "Попробовать ритмические варианты", idCounter++, Status.NEW);
        ArrayList<SubTask> listForQuartet = new ArrayList<>();
        taskManager.addSubTaskToEpic(searchTheme, listForQuartet);
        writeQuartet.setSubTasks(listForQuartet);


        taskManager.addTask(study);
        taskManager.addTask(work);

        taskManager.addSubTask(countLength);
        taskManager.addSubTask(cleanWindows);
        taskManager.addSubTask(searchTheme);

        taskManager.addEpic(changePipe);
        taskManager.addEpic(writeQuartet);

        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

        study.setStatus(Status.IN_PROGRESS);
        searchTheme.setStatus(Status.DONE);
        pipeChange.get(0).setStatus(Status.NEW);
        pipeChange.get(1).setStatus(Status.DONE);

        taskManager.updateEpicStatus(changePipe.getID());
        taskManager.updateEpicStatus(writeQuartet.getID());

        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

        taskManager.removeTaskByID(work.getID());
        taskManager.removeEpicByID(writeQuartet.getID());
        taskManager.removeSubTaskByID(searchTheme.getID());
        taskManager.removeSubTaskFromEpic(searchTheme, listForQuartet);
        taskManager.removeEpicByID(changePipe.getID());
        taskManager.updateEpicStatus(writeQuartet.getID());

        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

    }
}
