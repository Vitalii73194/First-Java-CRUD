import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nTASK MANAGER MENU");
            System.out.println("1. Show tasks");
            System.out.println("2. Add task");
            System.out.println("3. Edit task");
            System.out.println("4. Delete task\n");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showTasks();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    editTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // CREATE
    static void addTask() {
        System.out.print("Enter task: ");
        String task = sc.nextLine();

        tasks.add(task);
        System.out.println("Task added!");
    }

    // READ
    static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            System.out.print("Press ENTER to continue...");
            sc.nextLine();
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.print("Press ENTER to continue...");
        sc.nextLine();
    }

    // UPDATE
    static void editTask() {
        showTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Task number: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;

            if (index >= 0 && index < tasks.size()) {
                System.out.print("New task: ");
                tasks.set(index, sc.nextLine());
                System.out.println("Task updated!");
            } else {
                System.out.println("Task not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
    }

    // DELETE
    static void deleteTask() {
        showTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Task number: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;

            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task deleted!");
            } else {
                System.out.println("Task not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
    }
}