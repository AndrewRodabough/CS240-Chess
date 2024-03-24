package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

import java.util.List;

public class InvalidCommand extends State {
    @Override
    public String getSignature() { return "InvalidCommand"; }
    @Override
    public int getNumArgs() { return -1; }
    @Override
    public State Run(StateMachine sm) {
        System.out.print("Invalid Command: '");
        List<String> args = sm.getArgs();
        for(String arg : args) {
            System.out.print(arg);
        }
        System.out.print("'\n\n");

        sm.setArgs(null);
        return new Menu();
    }
}
