package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        if (tracker.delete(input.askInt("Enter id: "))) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        return true;
    }
}
