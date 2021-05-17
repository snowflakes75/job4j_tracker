package ru.job4j.tracker;

public class ChangeAction implements UserAction {
    private final Output out;

    public ChangeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Edit item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(input.askInt("Enter id"), item)) {
            this.out.println("Success");
        } else {
            this.out.println("Fail");
        }
        return true;
    }
}
