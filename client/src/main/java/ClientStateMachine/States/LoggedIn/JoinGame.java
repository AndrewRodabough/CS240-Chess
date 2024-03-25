package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.ServerFacade;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import chess.ChessGame;
import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;

public class JoinGame extends State{
    @Override
    public String getSignature() { return "join <ID> <[\"WHITE\"|\"BLACK\"|<empty>]>"; }
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
        int id;
        try {
            id = Integer.parseInt(args.get(0));
        } catch (NumberFormatException e) {
            System.out.println("the given id is not valid\nID: '" + args.get(0) + "'\n Expected: <INT>");
            return new Menu();
        }
        handler.JoinGame.JoinGameRequest joinReq = new handler.JoinGame.JoinGameRequest(args.get(1), id);
        String json = new Gson().toJson(joinReq);
        System.out.println(json);

        HttpResponse<String> res = ServerFacade.sendRequest("/game", "PUT", json, sm.createAuthHeader());
        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        System.out.println("game successfully joined\n");
        ChessGame.TeamColor teamColor = Objects.equals(args.get(1), "WHITE") ? ChessGame.TeamColor.WHITE : ChessGame.TeamColor.BLACK;

        sm.setGameID(id);
        sm.setTeamColor(teamColor);
        sm.setArgs(null);
        return new InGame();
    }
}