package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import java.util.List;

public class Login extends State {
    @Override
    public State Run(StateMachine sm) {

        List<String> args = sm.getArgs();
        if(args==null || args.size() < 2) {
            System.out.println("Not Enough Args:\n  'login <USERNAME> <PASSWORD>'\n");
            sm.setArgs(null);
            return new Menu();
        }

        String username = args.get(0);
        String password = args.get(1);

        System.out.println("Implement Login here");

        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedIn.Menu();
    }
}
