package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ====");
                    Item item = new Item(selectName(scanner));
                    tracker.add(item);
                }
                case 1 -> {
                    System.out.println("=== Show all items ===");
                    Item[] items = tracker.findAll();
                    for ( Item item: items) {
                        System.out.println(item);
                    }
                }
                case 2 -> {
                    System.out.println("=== Edit item ===");
                    Item item = new Item(selectName(scanner));
                    if (tracker.replace(selectId(scanner), item)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Fail");
                    }
                }
                case 3 -> {
                    System.out.println("=== Delete item ===");
                    if (tracker.delete(selectId(scanner))) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Fail");
                    }
                }
                case 4 -> {
                    System.out.println("=== Find item by Id ===");
                    Item item = tracker.findById(selectId(scanner));
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Fail");
                    }
                }
                case 5 -> {
                    System.out.println("=== Find items by name ===");
                    Item[] items = tracker.findByName(selectName(scanner));
                    if (items.length > 0) {
                        for (Item item: items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Fail");
                    }
                }
                case 6 -> run = false;
                default -> System.out.println("Wrong input");
            }
        }
    }

    private int selectId(Scanner scanner) {
        System.out.println("Enter id item: ");
        return Integer.valueOf(scanner.nextLine());
    }

    private String selectName(Scanner scanner) {
        System.out.println("Enter name item: ");
        return scanner.nextLine();
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
