package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import java.util.List;

public class Register extends State {
    @Override
    public State Run(StateMachine sm) {

        List<String> args = sm.getArgs();
        if(args==null || args.size() < 3) {
            System.out.println("Not Enough Args:\n  'register <USERNAME> <PASSWORD> <EMAIL>'\n");
            sm.setArgs(null);
            return new Menu();
        }

        String username = args.get(0);
        String password = args.get(1);
        String email = args.get(2);

        System.out.println("Implement Registation here");

        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedIn.Menu();
    }
}
