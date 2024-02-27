package dataAccess;

import model.AuthData;

abstract class AuthDAOInterface implements DAOInterface {
    static boolean createAuth(String username) { return false;}
    static AuthData getAuth(String username) { return null;}
    static AuthData getAuthFromToken(String authToken) { return null; }
    static boolean deleteAuth(AuthData auth) { return false;}
    static boolean clear() {
        return false;
    }
}
