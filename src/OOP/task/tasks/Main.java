package OOP.task.tasks;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private final String name;
    private final ArrayList<String> tasks;

    public Task(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println(tasks);
        System.out.println("added task -" + task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && tasks.size() > index) {
            tasks.remove(index);
            System.out.println(tasks + "topshiriq o'chirildi");
        } else {
            System.out.println("bunday id li topshiriq yo'q");
        }
    }

    public void listTask() {
        if (!tasks.isEmpty()) {
            System.out.println("user: " + name);
            System.out.println("Vazifalar ruyhati");
            int index = 1;
            for (String t :
                    tasks) {
                System.out.println(index + "." + t);
                index++;
            }
        } else {
            System.out.println("Task yaratilmagan");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ism kiriting");
        String name = scanner.next();
        Task task = new Task(name);
        System.out.println("raqam tanlang");


        while (true) {
            System.out.println("""
                    1.add task
                    2.list task
                    3.delete task
                    4.exit program""");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("task add");
                    String tasks = scanner.next();
                    task.addTask(tasks);
                    break;
                case 2:
                    task.listTask();
                    break;
                case 3:
                    System.out.println("o'chirmoqchi bolgan topshiriq id sini kiriting");
                    int index = scanner.nextInt();
                    task.deleteTask(index - 1);
                    break;
                case 4:
                    System.out.println("Dasturni tugatish");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("dastur tugatildi");
                    break;
            }
        }
    }
}
