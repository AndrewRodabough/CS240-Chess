package service;

import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import model.AuthData;
import model.UserData;

import java.util.Objects;

public class Login{
    public static AuthData Run(UserData user) {
        UserData userInDB = UserDAOMemory.GetUser(user.username());
        if(userInDB == null) { return null;}
        if(!(Objects.equals(userInDB.username(), user.username()) && Objects.equals(userInDB.password(), user.password()))) { return null; }
        AuthDAOMemory.CreateAuth(user.username());
        return AuthDAOMemory.GetAuth(user.username());
    }
}
