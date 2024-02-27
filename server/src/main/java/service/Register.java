package service;

import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import model.AuthData;
import model.UserData;

public class Register{
    public static AuthData Run(UserData user) {
        if(UserDAOMemory.getUser(user.username()) != null) { return null; } // user taken
        UserDAOMemory.createUser(user);
        AuthDAOMemory.createAuth(user.username());
        return AuthDAOMemory.getAuth(user.username());
    }
}
