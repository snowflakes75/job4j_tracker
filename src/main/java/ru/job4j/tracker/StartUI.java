package ru.job4j.tracker;

public class StartUI {
    private static int selectId(Input input) {
        return input.askInt("Enter id item: ");
    }

    private static String selectName(Input input) {
        return input.askStr("Enter name item: ");
    }

    private static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        Item item = new Item(selectName(input));
        tracker.add(item);
    }

    private static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        Item item = new Item(selectName(input));
        if (tracker.replace(selectId(input), item)) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    private static void deleteItems(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        if (tracker.delete(selectId(input))) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    private static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        Item item = tracker.findById(selectId(input));
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Fail");
        }
    }

    private static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        Item[] items = tracker.findByName(selectName(input));
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Fail");
        }
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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 -> StartUI.createItem(input, tracker);
                case 1 -> StartUI.showAllItems(tracker);
                case 2 -> StartUI.replaceItem(input, tracker);
                case 3 -> StartUI.deleteItems(input, tracker);
                case 4 -> StartUI.findItemById(input, tracker);
                case 5 -> StartUI.findItemByName(input, tracker);
                case 6 -> run = false;
                default -> System.out.println("Wrong input");
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
