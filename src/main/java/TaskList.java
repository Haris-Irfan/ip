import java.util.ArrayList;

public class TaskList {

    private static ArrayList<Task> tasks = new ArrayList<>(100);

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

    public void addTasks(Task newTask) {
        this.tasks.add(newTask);
    }

    public Task deleteTask(int position) throws KieTwoForOneException {
        try {
            return this.tasks.remove(position - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new KieTwoForOneException(String.format("No task at index %d!", position));
        }
    }

    public int countTasks() {
        return this.tasks.size();
    }

    public String markTask(int position) throws KieTwoForOneException {
        try {
            return this.tasks.get(position - 1).markTask();
        } catch (IndexOutOfBoundsException e) {
            throw new KieTwoForOneException("Task does not exist!");
        }
    }

    public String unmarkTask(int position) throws KieTwoForOneException {
        try {
            return this.tasks.get(position - 1).unmarkTask();
        } catch (IndexOutOfBoundsException e) {
            throw new KieTwoForOneException("Task does not exist!");
        }
    }

}
