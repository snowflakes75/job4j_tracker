package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Delete item ===");
        if (tracker.delete(input.askInt("Enter id: "))) {
            this.out.println("Success");
        } else {
            this.out.println("Fail");
        }
        return true;
    }
}
