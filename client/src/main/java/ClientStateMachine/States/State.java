package ClientStateMachine.States;
import ClientStateMachine.StateMachine;

public abstract class State {
    public abstract State Run(StateMachine sm);
}
