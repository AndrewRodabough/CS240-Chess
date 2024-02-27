package service;

import dataAccess.AuthDAOMemory;

public class Logout{
    public static boolean Run(String authToken)
    {
        if(authToken == null) { return false; }
        return AuthDAOMemory.DeleteAuth(authToken);
    }
}
