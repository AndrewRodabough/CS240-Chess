package service;

import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import model.AuthData;
import model.UserData;

import java.util.Objects;

public class Login{
    public static AuthData Run(UserData user) {
        UserData userInDB = UserDAOMemory.getUser(user.username());
        if(userInDB == null) { return null;}
        if(!(Objects.equals(userInDB.username(), user.username()) && Objects.equals(userInDB.password(), user.password()))) { return null; }
        AuthDAOMemory.createAuth(user.username());
        return AuthDAOMemory.getAuth(user.username());
    }
}
