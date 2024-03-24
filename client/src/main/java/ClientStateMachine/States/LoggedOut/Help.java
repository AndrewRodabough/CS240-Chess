package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Help extends State {
    public State Run(StateMachine sm) {
        System.out.print(
            """
            Valid Commands:
            'register <USERNAME> <PASSWORD> <EMAIL>'    - to create an account
            'login <USERNAME> <PASSWORD>'               - to play chess
            'help'                                      - shows possible commands
            'quit'                                      - exit program
            
            """
            );

        sm.setArgs(null);
        return new Menu();
    }
}
