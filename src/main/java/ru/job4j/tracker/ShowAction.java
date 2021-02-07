package ru.job4j.tracker;

public class ShowAction implements UserAction{
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            this.out.println(item);
        }
        return true;
    }
}
