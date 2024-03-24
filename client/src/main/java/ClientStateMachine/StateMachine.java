package ClientStateMachine;

import ClientStateMachine.States.*;
import chess.ChessGame;
import model.AuthData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StateMachine {
    private boolean loginStatus = false;
    private AuthData auth = null;
    private State currentState;
    private List<String> args = null;
    private ChessGame.TeamColor teamColor = null;
    private final Scanner scanner = new Scanner(System.in);
    private static final HashMap<String, State> loggedOutCommands = new HashMap<>();
    private static final HashMap<String, State> loggedInCommands = new HashMap<>();
    private static final State DEFAULT_STATE = new ClientStateMachine.States.LoggedOut.Menu();

    static {
        loggedOutCommands.put("help", new ClientStateMachine.States.LoggedOut.Help());
        loggedOutCommands.put("menu", new ClientStateMachine.States.LoggedOut.Menu());
        loggedOutCommands.put("login", new ClientStateMachine.States.LoggedOut.Login());
        loggedOutCommands.put("quit", new ClientStateMachine.States.LoggedOut.Quit());
        loggedOutCommands.put("register", new ClientStateMachine.States.LoggedOut.Register());

        loggedInCommands.put("help", new ClientStateMachine.States.LoggedIn.Help());
        loggedInCommands.put("menu", new ClientStateMachine.States.LoggedIn.Menu());
        loggedInCommands.put("logout", new ClientStateMachine.States.LoggedIn.Logout());
        loggedInCommands.put("join", new ClientStateMachine.States.LoggedIn.JoinGame());
        loggedInCommands.put("list", new ClientStateMachine.States.LoggedIn.ListGame());
        loggedInCommands.put("observe", new ClientStateMachine.States.LoggedIn.JoinObserver());
        loggedInCommands.put("create", new ClientStateMachine.States.LoggedIn.CreateGame());
    }
    public StateMachine() { currentState = DEFAULT_STATE; }
    public StateMachine(State state) { currentState = state; }

    public static HashMap<String, State> getLoggedOutCommands() { return loggedOutCommands; }
    public static HashMap<String, State> getLoggedInCommands() { return loggedInCommands; }
    public boolean getLoginStatus() { return loginStatus; }
    public void setLoginStatus(boolean loginStatus) { this.loginStatus = loginStatus; }
    public AuthData getAuth() { return auth; }
    public void setAuth(AuthData auth) { this.auth = auth; }
    public Scanner getScanner() { return scanner; }
    public List<String> getArgs() { return args; }
    public void setArgs(List<String> args) { this.args = args; }
    public ChessGame.TeamColor getTeamColor() { return teamColor; }
    public void setTeamColor(ChessGame.TeamColor teamColor) { this.teamColor = teamColor; }

    public Map<String, String> createAuthHeader() {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization", auth.authToken());
        return header;
    }

    /**
     * for debug and unit tests only
     */
    public void SetCurrentState(State state) { currentState = state; }

    public void Run() {
        while (currentState != null) {
            currentState = currentState.Run(this);
        }
    }
}
