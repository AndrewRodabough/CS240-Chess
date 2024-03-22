package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class ListGame extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement List Here");
        sm.setArgs(null);
        return new Menu();
    }
}