package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.ConsoleStateMachine;
import ClientStateMachine.States.State;

public class Help extends State {
    public State Run(ConsoleStateMachine sm) {
        System.out.print(
            """
            Valid Commands:
            'help'
            'login'
            'quit'
            'register'
            
            """
            );
        return new ClientStateMachine.States.LoggedOut.GetPrompt();
    }
}
