package service;

import dataAccess.AuthDAOSQL;
import dataAccess.AuthDAOMemory;

public class Logout{
    public static boolean Run(String authToken)
    {
        if(authToken == null) { return false; }
        try {
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
