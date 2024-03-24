package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import com.google.gson.Gson;
import model.AuthData;
import model.GameData;
import model.UserData;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGame extends State{
    @Override
    public String getSignature() { return "create <NAME>"; }
    @Override
    public int getNumArgs() { return 1; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        List<String> args = sm.getArgs();
        GameData gameReq = new GameData(-1, null, null, args.get(0), null);
        String json = new Gson().toJson(gameReq);
        System.out.println(json);

        HttpResponse<String> res = HTTPHandler.sendRequest("/game", "POST", json, sm.createAuthHeader());

        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        GameData gameRes = new Gson().fromJson(res.body(), GameData.class);
        System.out.println("Game Created\nGameID: '" + gameRes.gameID() + "'\n");

        sm.setArgs(null);
        return new Menu();
    }
}