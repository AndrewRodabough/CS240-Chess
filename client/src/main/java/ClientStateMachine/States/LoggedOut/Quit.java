package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.ConsoleStateMachine;
import ClientStateMachine.States.State;

public class Quit extends State{
    @Override
    public State Run(ConsoleStateMachine sm) {
        System.out.println("Goodbye :)");
        return null;
    }
}
