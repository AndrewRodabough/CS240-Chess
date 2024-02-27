package dataAccess;

import java.util.Map;
import java.util.HashMap;
import model.UserData;

public class UserDAOMemory extends UserDAOInterface{
    static Map<String, UserData> map = new HashMap<>();

    public static boolean CreateUser(UserData user) {
        map.put(user.username(), user);
        return true;
    }
    public static UserData GetUser(String username) {
        if(!map.containsKey(username)) { return null; }
        return map.get(username);
    }
    public static boolean Clear() {
        map.clear();
        return true;
    }
}
