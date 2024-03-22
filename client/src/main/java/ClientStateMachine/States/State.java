package ClientStateMachine.States;
import ClientStateMachine.ConsoleStateMachine;
import ClientStateMachine.States.*;

public abstract class State {
    public abstract State Run(ConsoleStateMachine sm);
}
