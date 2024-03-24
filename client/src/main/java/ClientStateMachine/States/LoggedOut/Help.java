package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Help extends State {
    @Override
    public String getSignature() { return "help"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

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
