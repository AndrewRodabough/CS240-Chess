package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu extends State{
    @Override
    public String getSignature() { return "menu"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        System.out.print("[LOGGED OUT] >>> ");
        String input = sm.getScanner().nextLine();
        List<String> tokens = new ArrayList<String>(List.of(input.split("\\s+")));

        String command = tokens.getFirst();
        List<String> args;
        if(tokens.size() > 1) {
            args = tokens.subList(1, tokens.size());
        } else {
            args = null;
        }

        if(!StateMachine.getLoggedOutCommands().containsKey(command)) {
            sm.setArgs(Arrays.asList(command));
            return new InvalidCommand();
        }
        else {
            sm.setArgs(args);
            return StateMachine.getLoggedOutCommands().get(command);
        }
    }

}
