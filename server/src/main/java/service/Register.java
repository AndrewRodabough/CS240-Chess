package service;

import dataAccess.AuthDAOSQL;
import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import model.AuthData;
import model.UserData;

public class Register{
    public static AuthData Run(UserData user) {
        if(UserDAOMemory.getUser(user.username()) != null) { return null; } // user taken
        UserDAOMemory.createUser(user);

        try {
            AuthDAOSQL.createAuth(user.username());
            return AuthDAOSQL.getAuth(user.username());
        } catch (Exception e) {
            return null;
        }

        /*
        if(UserDAOMemory.getUser(user.username()) != null) { return null; } // user taken
        UserDAOMemory.createUser(user);
        AuthDAOMemory.createAuth(user.username());
        return AuthDAOMemory.getAuth(user.username());
         */
    }
}
