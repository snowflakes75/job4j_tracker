package ru.job4j.tracker;

public class StartUI {

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
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
                System.out.println("Wrong input");
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ChangeAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new CloseAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
