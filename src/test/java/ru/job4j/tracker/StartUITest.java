package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenCreate2Item() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "0", "Fix PC", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(1).getName(), is("Item name"));
        assertThat(tracker.findById(2).getName(), is("Fix PC"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "New item name", "1", "1"}
        );
        UserAction[] actions = {
                new ChangeAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CloseAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()+
                        "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        Input input = new StubInput(
            new String[] {"0", "1"}
        );
        Item item = new Item("some");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new ShowAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
           "Menu." + System.lineSeparator() +
                   "0. Show all" + System.lineSeparator() +
                   "1. Exit" + System.lineSeparator() +
                   "=== Show all items ===" + System.lineSeparator() +
                   item.toString() + System.lineSeparator() +
                   "Menu." + System.lineSeparator() +
                   "0. Show all" + System.lineSeparator() +
                   "1. Exit" + System.lineSeparator() +
                   "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "some" ,"1"}
        );
        Item item = new Item("some");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new FindByNameAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by name ===" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "1" ,"1"}
        );
        Item item = new Item("some");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new FindByIdAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find item by Id ===" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exit Program ===" + System.lineSeparator()
        ));
    }
}

