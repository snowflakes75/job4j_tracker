package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Find item by Id ===");
        Item item = tracker.findById(input.askInt("Enter id: "));
        this.out.println(Objects.requireNonNullElse(item, "Fail"));
        return true;
    }
}
