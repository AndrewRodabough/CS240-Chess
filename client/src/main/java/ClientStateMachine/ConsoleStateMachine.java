package ClientStateMachine;

import ClientStateMachine.States.State;

import java.io.Console;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleStateMachine {
    private boolean loginStatus = false;
    private String AuthToken = "";
    private Scanner scanner = new Scanner(System.in);
    private static HashMap<String, State> loggedOutCommands = new HashMap<>();
    private static HashMap<String, State> loggedInCommands = new HashMap<>();
    private State currentState;
    private static final State DEFAULT_STATE = new ClientStateMachine.States.LoggedOut.GetPrompt();

    static {
        loggedOutCommands.put("help", new ClientStateMachine.States.LoggedOut.Help());
        loggedOutCommands.put("get prompt", new ClientStateMachine.States.LoggedOut.GetPrompt());
        loggedOutCommands.put("login", new ClientStateMachine.States.LoggedOut.Login());
        loggedOutCommands.put("guit", new ClientStateMachine.States.LoggedOut.Quit());
        loggedOutCommands.put("register", new ClientStateMachine.States.LoggedOut.Register());
    }
    public ConsoleStateMachine() { currentState = DEFAULT_STATE; }
    public ConsoleStateMachine(State state) { currentState = state; }

    public static HashMap<String, State> getLoggedOutCommands() { return loggedOutCommands; }
    public static HashMap<String, State> getLoggedInCommands() { return loggedInCommands; }
    public boolean getLoginStatus() { return loginStatus; }
    public void setLoginStatus(boolean loginStatus) { this.loginStatus = loginStatus; }
    public String getAuthToken() { return AuthToken; }
    public void setAuthToken(String authToken) { AuthToken = authToken; }
    public Scanner getScanner() { return scanner; }

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
