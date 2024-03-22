package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Logout extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement Logout Here");
        System.out.println("You are now logged out\n");
        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedOut.Menu();
    }
}