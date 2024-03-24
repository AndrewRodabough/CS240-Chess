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
    public String getSignature() { return "login <USERNAME> <PASSWORD>"; }
    @Override
    public int getNumArgs() { return 2; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        List<String> args = sm.getArgs();
        UserData user = new UserData(args.get(0), args.get(1), null);
        String json = new Gson().toJson(user);
        System.out.println(json);

        HttpResponse<String> res = HTTPHandler.sendRequest("/session", "POST", json, null);
        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new Menu();
        }

        AuthData auth = new Gson().fromJson(res.body(), AuthData.class);
        System.out.println(auth.toString());
        System.out.println();

        sm.setAuth(auth);
        sm.setArgs(null);
        return new Menu();
    }
}
