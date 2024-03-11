package service;

import dataAccess.AuthDAOSQL;
import dataAccess.DataAccessException;
import model.AuthData;

public class Authorize {
    public static boolean Run(String AuthToken) {
        if(AuthToken == null) { return false; }
        try {
            AuthData auth = AuthDAOSQL.getAuthFromToken(AuthToken);
            return auth != null;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
