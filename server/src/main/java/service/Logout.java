package service;

import dataAccess.AuthDAOSQL;
import dataAccess.DataAccessException;
import model.AuthData;

public class Logout{
    public static boolean Run(String authToken)
    {

        if(authToken == null) { return false; }
        try {
            AuthData auth = AuthDAOSQL.getAuthFromToken(authToken);
            if(auth == null) { throw new DataAccessException("not logged in"); }

            AuthDAOSQL.deleteAuth(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }

        /*
        if(authToken == null) { return false; }
        return AuthDAOMemory.deleteAuth(authToken);
         */
    }
}
