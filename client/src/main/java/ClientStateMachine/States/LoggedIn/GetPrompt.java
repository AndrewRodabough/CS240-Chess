package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.ConsoleStateMachine;
import ClientStateMachine.States.State;

public class GetPrompt extends State {
    public State Run(ConsoleStateMachine sm){
        System.out.print("[LOGGED IN] >>> ");
        String prompt = sm.getScanner().nextLine();

        if(!ConsoleStateMachine.getLoggedInCommands().containsKey(prompt)) {
            System.out.println("unrecognized command (type \"help\" to get list of commands");
            return this;
        }
        else {
            return ConsoleStateMachine.getLoggedInCommands().get(prompt);
        }
    }
}
