package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import chess.ChessGame;

public class JoinGame extends State{
    @Override
    public State Run(StateMachine sm) {
        System.out.println("Implement Join Game here");

        sm.setArgs(null);
        sm.setTeamColor(ChessGame.TeamColor.WHITE); // implement
        return new ClientStateMachine.States.LoggedIn.InGame();
    }
}