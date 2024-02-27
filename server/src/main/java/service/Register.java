package service;

import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import model.AuthData;
import model.UserData;

public class Register{
    public static AuthData Run(UserData user) {
        if(UserDAOMemory.GetUser(user.username()) != null) { return null; } // user taken
        UserDAOMemory.CreateUser(user);
        AuthDAOMemory.CreateAuth(user.username());
        return AuthDAOMemory.GetAuth(user.username());
    }
}
