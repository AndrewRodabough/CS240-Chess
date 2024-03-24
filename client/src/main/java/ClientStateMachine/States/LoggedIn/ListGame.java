package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import model.GameData;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class ListGame extends State{
    @Override
    public String getSignature() { return "list"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        HttpResponse<String> res = HTTPHandler.sendRequest("/game", "GET", "", sm.createAuthHeader());

        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        Collection<GameData> games = new Gson().fromJson(res.body(), handler.ListGames.games.class).games();
        System.out.println("Current Games:");
        for(GameData game : games) {
            System.out.println(game.toString());
        }
        System.out.println();

        sm.setArgs(null);
        return new Menu();
    }
}