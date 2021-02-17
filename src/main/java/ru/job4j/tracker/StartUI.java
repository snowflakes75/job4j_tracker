package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    private void showMenu(List<UserAction> actions) {
        this.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            this.out.println(i + ". " + actions.get(i).name());
        }
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ShowAction(output),
                new ChangeAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new CloseAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
