package dataAccess;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import model.AuthData;

public class AuthDAOMemory extends AuthDAOInterface {
    static Map<String, AuthData> mapT = new HashMap<>();
    static Map<String, AuthData> mapU = new HashMap<>();

    public static boolean CreateAuth(String username) {
        String AuthToken = UUID.randomUUID().toString();
        mapT.put(AuthToken, new AuthData(username, AuthToken));
        mapU.put(username, new AuthData(username, AuthToken));
        return true;
    }
    public static AuthData GetAuth(String username) {
        if(!mapU.containsKey(username)) { return null; }
        return mapU.get(username);
    }
    public static boolean DeleteAuth(AuthData auth) {
        return false;
    }
    public static boolean Clear() {
        mapT.clear();
        mapU.clear();
        return true;
    }
}
