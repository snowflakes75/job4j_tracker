package ru.job4j.tracker;

public class ChangeAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(input.askInt("Enter id"), item)) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        return true;
    }
}
