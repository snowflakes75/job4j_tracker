package ru.job4j.tracker;

public class StartUI {
    private static int selectId(Input input) {
        return input.askInt("Enter id item: ");
    }

    private static String selectName(Input input) {
        return input.askStr("Enter name item: ");
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        Item item = new Item(selectName(input));
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        Item item = new Item(selectName(input));
        if (tracker.replace(selectId(input), item)) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    public static void deleteItems(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        if (tracker.delete(selectId(input))) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        Item item = tracker.findById(selectId(input));
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Fail");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select >= 0 && select <= actions.length) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ChangeAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new CloseAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
