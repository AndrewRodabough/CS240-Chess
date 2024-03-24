package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Help extends State{
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
                'create <NAME>'                 - create a game
                'help'                          - to play chess
                'join <ID> <["WHITE"|"BLACK"]>' - join a game
                'observe <ID>'                  - observe a game
                'list'                          - show games list
                'logout'                        - return to "LoggedOut" state
                
                """
        );

        sm.setArgs(null);
        return new Menu();
    }
}