package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Logout extends State{
    @Override
    public String getSignature() { return ""; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement Logout Here");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("authorization", sm.getAuth().authToken());

        HttpResponse<String> res = HTTPHandler.sendRequest("/session", "DELETE", "", headers);

        if(res == null) {
            System.out.println("ERROR, no response from server");
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }
        if(res.statusCode() != 200) {
            System.out.println("ERROR, status code was not 200. Code: " + res.statusCode());
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        System.out.println("You are now logged out\n");

        sm.setAuth(null);
        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedOut.Menu();
    }
}