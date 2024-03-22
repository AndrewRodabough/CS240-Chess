package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class Quit extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Goodbye :)");
        sm.setArgs(null);
        return null;
    }
}
