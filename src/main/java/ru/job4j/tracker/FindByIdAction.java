package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askInt("Enter id: "));
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Fail");
        }
        return true;
    }
}
