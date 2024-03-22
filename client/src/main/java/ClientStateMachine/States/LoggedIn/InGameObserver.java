package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class InGameObserver extends State {
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement In Game Observer");
        sm.setArgs(null);
        return null;
    }
}
