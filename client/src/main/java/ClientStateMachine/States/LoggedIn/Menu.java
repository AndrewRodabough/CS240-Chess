package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import java.util.ArrayList;
import java.util.List;

public class Menu extends State {
    @Override
    public String getSignature() { return ""; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm){
        System.out.print("[LOGGED IN] >>> ");
        String input = sm.getScanner().nextLine();
        List<String> tokens = new ArrayList<String>(List.of(input.split("\\s+")));

        String command = tokens.getFirst();
        List<String> args;
        if(tokens.size() > 1) {
            args = tokens.subList(1, tokens.size());
        } else {
            args = null;
        }

        if(!StateMachine.getLoggedInCommands().containsKey(command)) {
            System.out.println("unrecognized command (type \"help\" to get list of commands\n");

            sm.setArgs(null);
            return this;
        }
        else {
            sm.setArgs(args);
            return StateMachine.getLoggedInCommands().get(command);
        }
    }
}
