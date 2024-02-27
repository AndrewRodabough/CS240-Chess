package dataAccess;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import model.AuthData;

public class AuthDAOMemory extends AuthDAOInterface {
    static Map<String, AuthData> mapT = new HashMap<>();
    static Map<String, AuthData> mapU = new HashMap<>();

    public static boolean createAuth(String username) {
        String AuthToken = UUID.randomUUID().toString();
        mapT.put(AuthToken, new AuthData(username, AuthToken));
        mapU.put(username, new AuthData(username, AuthToken));
        return true;
    }
    public static AuthData getAuth(String username) {
        if(!mapU.containsKey(username)) { return null; } // username does not have Auth
        return mapU.get(username);
    }
    public static AuthData getAuthFromToken(String authToken) {
        if(!mapT.containsKey(authToken)) { return null; } // token does not exist
        return mapT.get(authToken);
    }
    public static boolean deleteAuth(String authToken) {
        if(!mapT.containsKey(authToken)) { return false; } // token does not exist
        AuthData auth = mapT.get(authToken);
        mapT.remove(authToken);
        mapU.remove(auth.username());
        return true;
    }
    public static boolean clear() {
        mapT.clear();
        mapU.clear();
        return true;
    }
}
