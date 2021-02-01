package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getCreated().format(
                DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));

        Tracker tracker = new Tracker();
        Item itemSecond = new Item("Some test");
        tracker.add(itemSecond);
        System.out.println(tracker.findById(1).toString());
    }
}
