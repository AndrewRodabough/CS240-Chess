package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import chess.ChessGame;

public class JoinObserver extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement Observe Game here");

        sm.setTeamColor(null); // implement
        sm.setArgs(null);
        return new ClientStateMachine.States.LoggedIn.InGameObserver();
    }
}