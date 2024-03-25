package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.ServerFacade;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;

import java.net.http.HttpResponse;

public class Logout extends State{
    @Override
    public String getSignature() { return "logout"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        HttpResponse<String> res = ServerFacade.sendRequest("/session", "DELETE", "", sm.createAuthHeader());

        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        System.out.println("logout successful\n");

        sm.setAuth(null);
        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedOut.Menu();
    }
}