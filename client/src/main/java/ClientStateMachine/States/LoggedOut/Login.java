package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import com.google.gson.Gson;
import model.AuthData;
import model.UserData;

import java.net.http.HttpResponse;
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
        if(args.size() > 2) {
            System.out.println("Too Many Args:\n  'login <USERNAME> <PASSWORD>'\n");
            sm.setArgs(null);
            return new Menu();
        }

        String username = args.get(0);
        String password = args.get(1);
        UserData user = new UserData(username, password, null);

        String json = new Gson().toJson(user);
        System.out.println(json);

        HttpResponse<String> res = HTTPHandler.sendRequest("/session", "POST", json);

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
