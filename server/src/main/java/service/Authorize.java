package service;

import dataAccess.AuthDAOMemory;
import model.AuthData;

public class Authorize {
    public static boolean Run(String AuthToken) {
        if(AuthToken == null) { return false; }
        AuthData auth = AuthDAOMemory.GetAuthFromToken(AuthToken);
        if(auth == null) { return false; }
        return auth.authToken() == AuthToken;
    }
}
