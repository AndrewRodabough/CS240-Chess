package ClientStateMachine.States.LoggedOut;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import model.AuthData;
import model.UserData;

import ClientStateMachine.HTTPHandler;

import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.List;

public class Register extends State {
    @Override
    public String getSignature() { return "register <USERNAME> <PASSWORD> <EMAIL>"; }
    @Override
    public int getNumArgs() { return 3; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        List<String> args = sm.getArgs();
        UserData user = new UserData(args.get(0), args.get(1), args.get(2));
        String json = new Gson().toJson(user);
        System.out.println(json);

        HttpResponse<String> res = HTTPHandler.sendRequest("/user", "POST", json, null);
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
        return new ClientStateMachine.States.LoggedIn.Menu();
    }
}
