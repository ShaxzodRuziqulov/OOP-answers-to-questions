package Task;
import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    ArrayList<String> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        // Check if tasks ArrayList is null before adding a task
        if (this.tasks != null) {
            this.tasks.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Error: Task list is not initialized.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < this.tasks.size()) {
            String removedTask = this.tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index provided");
        }
    }

    public void listTasks() {
        System.out.println("User: " + this.name);
        System.out.println("Tasks list:");
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ". " + this.tasks.get(i));
        }
    }
}

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        User user = new User(name);

        while (true) {
            System.out.println("\nActions:\n1. Add Task\n2. Remove Task\n3. List Tasks\n0. Exit");
            System.out.print("Choose (0-3): ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter task to add: ");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    user.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int index = scanner.nextInt();
                    user.removeTask(index - 1);
                    break;

                case 3:
                    user.listTasks();
                    break;

                case 0:
                    System.out.println("Program exited.");
                    System.exit(0);

                default:
                    System.out.println("Invalid action chosen. Please try again.");
            }
        }
    }
}

