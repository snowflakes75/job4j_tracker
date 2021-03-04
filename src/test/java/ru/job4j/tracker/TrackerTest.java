package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortByHigh() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item("Bug");
        Item fix = new Item("Z bug");
        Item problem = new Item("A bug");
        tracker.add(bug);
        tracker.add(fix);
        tracker.add(problem);
        List<Item> list = tracker.findAll();
        Collections.sort(list, new SortByNameItem());
        assertThat(list, is(Arrays.asList(problem, bug, fix)));
    }

    @Test
    public void whenSortByRevers() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item("Bug");
        Item fix = new Item("Z bug");
        Item problem = new Item("A bug");
        tracker.add(bug);
        tracker.add(fix);
        tracker.add(problem);
        List<Item> list = tracker.findAll();
        Collections.sort(list, new SortByNameItem().reversed());
        assertThat(list, is(Arrays.asList(fix, bug, problem)));
    }
}