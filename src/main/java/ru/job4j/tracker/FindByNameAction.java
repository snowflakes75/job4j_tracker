package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Find items by name ===");
        List<Item> items = tracker.findByName(input.askStr("Enter name: "));
        if (items.size() > 0) {
            for (Item item : items) {
                this.out.println(item);
            }
        } else {
            this.out.println("Fail");
        }
        return true;
    }
}
