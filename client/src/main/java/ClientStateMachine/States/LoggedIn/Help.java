package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Help extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.print(
                """
                Valid Commands:
                'create <NAME>'                         - create a game
                'help'                                  - to play chess
                'join <ID> <["WHITE"|"BLACK"|<empty>]>' - join a game
                'observe <ID>'                          - observe a game
                'list'                                  - show games list
                'logout'                                - return to "LoggedOut" state
                """
        );

        sm.setArgs(null);
        return new Menu();
    }
}