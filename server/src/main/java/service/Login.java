package service;

import dataAccess.AuthDAOSQL;
import dataAccess.UserDAOSQL;
import model.AuthData;
import model.UserData;

import java.util.Objects;

public class Login{
    public static AuthData Run(UserData user) {




        try {
            UserData userInDB = UserDAOSQL.getUser(user.username());
            if(userInDB == null) { return null;}
            if(!(Objects.equals(userInDB.username(), user.username()) && Objects.equals(userInDB.password(), user.password()))) { return null; }
            String authToken = AuthDAOSQL.createAuth(user.username());
            return AuthDAOSQL.getAuthFromToken(authToken);
        } catch (Exception e) {
            return null;
        }
        /*
        UserData userInDB = UserDAOMemory.getUser(user.username());
        if(userInDB == null) { return null;}
        if(!(Objects.equals(userInDB.username(), user.username()) && Objects.equals(userInDB.password(), user.password()))) { return null; }

        try {
            String authToken = AuthDAOSQL.createAuth(user.username());
            return AuthDAOSQL.getAuthFromToken(authToken);
        } catch (Exception e) {
            return null;
        }
        */
    }
}
