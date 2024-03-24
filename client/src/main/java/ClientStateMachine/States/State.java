package ClientStateMachine.States;

import ClientStateMachine.StateMachine;
import java.net.http.HttpResponse;
import java.util.List;

public abstract class State {
    public abstract String getSignature();
    public abstract int getNumArgs();
    public abstract State Run(StateMachine sm);
    public Boolean checkArgs(StateMachine sm) {

        List<String> args = sm.getArgs();
        int numArgsExpected = getNumArgs();
        int numArgsGiven = args==null? 0:args.size();

        if (numArgsExpected == -1) {
            // -1 signifies any number of args
            return true;
        }

        if(numArgsGiven < numArgsExpected) {
            System.out.println("Not Enough Args:\n  Expected: '" + getSignature() + "'\n");
            return false;
        }
        if(numArgsGiven > numArgsExpected) {
            System.out.println("Too Many Args:\n  Expected: '" + getSignature() + "'\n");
            return false;
        }
        return true;
    }
    public Boolean checkStatus(HttpResponse<String> res) {
        if(res == null) {
            System.out.println("ERROR, no response from server");
            return false;
        }
        if(res.statusCode() != 200) {
            System.out.println("ERROR, status code was not 200. Code: " + res.statusCode());
            return false;
        }
        return true;
    }
}
