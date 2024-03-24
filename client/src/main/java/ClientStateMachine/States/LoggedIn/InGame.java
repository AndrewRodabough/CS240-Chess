package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

public class InGame extends State {
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement In Game\n");
        sm.setArgs(null);
        return null;
    }
}
