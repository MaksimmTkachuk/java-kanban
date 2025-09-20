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

        Task ucheba = new Task("Пройти спринт", "Успеть до жесткого дедлайна пройти 5й спринт", idCounter++, Status.NEW);
        Task rabota = new Task("Получить категорию", "Собрать все дипломы и прочую документацию", idCounter++, Status.NEW);


        SubTask countLength = new SubTask("Замерить трубу", "Рассчитать рулеткой расстояние", idCounter++, Status.NEW);
        SubTask cleanWindows = new SubTask("Почистить окна", "Почистить окна для трубы", idCounter++, Status.NEW);
        ArrayList<SubTask> pipeChange = new ArrayList<>();
        taskManager.addSubTask(countLength, pipeChange);
        taskManager.addSubTask(cleanWindows,pipeChange);
        Epic changePipe = new Epic("Заменить трубу", "Вырезать металлическую трубу и заменить ей гофру", idCounter++, Status.NEW, pipeChange);

        SubTask searchTheme = new SubTask("Найти вторую тему", "Попробовать ритмические варианты", idCounter++, Status.NEW);
        ArrayList<SubTask> listForQuartet = new ArrayList<>();
        taskManager.addSubTask(searchTheme, listForQuartet);
        Epic writeQuartet = new Epic("Закончить квартет", "Закончить к ноябрю весь материал", idCounter++, Status.NEW, listForQuartet);

        taskManager.addTask(ucheba);
        taskManager.addTask(rabota);

        taskManager.addTask(countLength);
        taskManager.addTask(cleanWindows);
        taskManager.addTask(searchTheme);

        taskManager.addTask(changePipe);
        taskManager.addTask(writeQuartet);


        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

        ucheba.setStatus(Status.IN_PROGRESS);
        searchTheme.setStatus(Status.DONE);
        pipeChange.get(0).setStatus(Status.NEW);
        pipeChange.get(1).setStatus(Status.DONE);

        taskManager.countEpicStatus(changePipe);
        taskManager.countEpicStatus(writeQuartet);

        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

        taskManager.removeTaskByID(rabota.getID());
        taskManager.removeEpicByID(writeQuartet.getID());

        System.out.println(taskManager.getTaskList());
        System.out.println(taskManager.getSubTaskList());
        System.out.println(taskManager.getEpicList());

    }
}
