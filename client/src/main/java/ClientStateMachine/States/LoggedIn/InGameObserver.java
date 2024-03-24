package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class InGameObserver extends State {
    @Override
    public String getSignature() { return ""; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement In Game Observer\n");
        sm.setArgs(null);
        return null;
    }
}