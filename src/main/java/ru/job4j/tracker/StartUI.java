package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    private void showMenu(UserAction[] actions) {
        this.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            this.out.println(i + ". " + actions[i].name());
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select >= 0 && select <= actions.length) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } else {
                this.out.println("Wrong input");
            }
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAction(output),
                new ChangeAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new CloseAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
