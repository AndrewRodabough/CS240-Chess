package service;

import dataAccess.AuthDAOMemory;
import dataAccess.AuthDAOSQL;
import dataAccess.DataAccessException;
import model.AuthData;

import java.util.Objects;

public class Authorize {
    public static boolean Run(String AuthToken) {
        if(AuthToken == null) { return false; }
        try {
            AuthData auth = AuthDAOSQL.getAuthFromToken(AuthToken);
            return true;
        } catch (DataAccessException e) {
            return false;
        }

        /*
        if(AuthToken == null) { return false; }
        AuthData auth = AuthDAOMemory.getAuthFromToken(AuthToken);
        if(auth == null) { return false; }
        return Objects.equals(auth.authToken(), AuthToken);
        */
    }
}
