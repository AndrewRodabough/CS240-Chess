package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import com.google.gson.Gson;
import model.AuthData;
import model.UserData;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGame extends State{
    @Override
    public String getSignature() { return ""; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        List<String> args = sm.getArgs();
        if(args.size() < 1) {
            System.out.println("Not Enough Args:\n  'create <NAME>'\n");
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }
        if(args.size() > 1) {
            System.out.println("Too Many Args:\n  'create <NAME>'\n");
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("authorization", sm.getAuth().authToken());

        String name = args.get(0);
        String json = new Gson().toJson(name);
        System.out.println(json);

        HttpResponse<String> res = HTTPHandler.sendRequest("/session", "POST", json, null);

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

        AuthData auth = new Gson().fromJson(res.body(), AuthData.class);
        System.out.println(auth.toString());
        System.out.println();

        sm.setAuth(auth);
        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedIn.Menu();
    }
}