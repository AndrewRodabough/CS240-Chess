package dataAccess;

import model.AuthData;

abstract class AuthDAOInterface implements DAOInterface {
    static boolean CreateAuth(String username) { return false;}
    static AuthData GetAuth(String username) { return null;}
    static boolean DeleteAuth(AuthData auth) { return false;}
    static boolean Clear() {
        return false;
    }
}
