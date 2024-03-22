package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.ConsoleStateMachine;
import ClientStateMachine.States.State;

public class GetPrompt extends State{
    @Override
    public State Run(ConsoleStateMachine sm) {
        System.out.print("[LOGGED OUT] >>> ");
        String prompt = sm.getScanner().nextLine();

        if(!ConsoleStateMachine.getLoggedOutCommands().containsKey(prompt)) {
            System.out.println("unrecognized command (type \"help\" to get list of commands");
            return this;
        }
        else {
            return ConsoleStateMachine.getLoggedOutCommands().get(prompt);
        }
    }

}
