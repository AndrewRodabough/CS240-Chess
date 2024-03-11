package service;

import dataAccess.AuthDAOSQL;
import dataAccess.UserDAOSQL;
import model.AuthData;
import model.UserData;

public class Register{
    public static AuthData Run(UserData user) {
        try {
            if(UserDAOSQL.getUser(user.username()) != null) { return null; } // user taken
            UserDAOSQL.createUser(user);
            AuthDAOSQL.createAuth(user.username());
            return AuthDAOSQL.getAuth(user.username());
        } catch (Exception e) {
            return null;
        }
        /*
        if(UserDAOMemory.getUser(user.username()) != null) { return null; } // user taken
        UserDAOMemory.createUser(user);

        try {
            AuthDAOSQL.createAuth(user.username());
            return AuthDAOSQL.getAuth(user.username());
        } catch (Exception e) {
            return null;
        }
         */
    }
}
