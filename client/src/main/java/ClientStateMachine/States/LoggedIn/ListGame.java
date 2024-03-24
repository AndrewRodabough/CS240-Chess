package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class ListGame extends State{
    @Override
    public String getSignature() { return ""; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement List Here\n");
        sm.setArgs(null);
        return new Menu();
    }
}