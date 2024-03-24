package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.HTTPHandler;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import chess.ChessGame;
import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;

public class InGameObserver extends State {
    @Override
    public String getSignature() { return "observer"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {

        System.out.println("Implement In Game Observer Here");
        sm.setArgs(null);
        return null;
    }
}
