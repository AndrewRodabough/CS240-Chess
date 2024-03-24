package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class CreateGame extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement Create Game here\n");
        sm.setArgs(null);
        return new Menu();
    }
}