package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;

    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    private Tracker() {
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item: items) {
            if (item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }

    public boolean replace(int id, Item item) {
        boolean replaceStatus = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            replaceStatus = true;
        }
        return replaceStatus;
    }

    public boolean delete(int id) {
        boolean deleteStatus = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}