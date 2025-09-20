package task;

public class SubTask extends Task {

    private int EpicID;

    public SubTask(String title, String description, int idCounter, Status status) {
        super(title, description, idCounter, status);
        this.EpicID = idCounter;
    }


    public int getEpicID() {
        return EpicID;
    }

    public void setEpicID(int epicID) {
        EpicID = epicID;
    }


    @Override
    public String toString() {
        return "SubTask{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID=" + getID() +
                ", status=" + getStatus() +
                ", epicID=" + getEpicID() +
                '}';
    }

}


