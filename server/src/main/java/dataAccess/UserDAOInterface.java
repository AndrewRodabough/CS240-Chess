package dataAccess;

import model.UserData;

abstract class UserDAOInterface implements DAOInterface {
    static boolean createUser(UserData user) { return false; }
    static UserData getUser(String username) { return null; }
    public static boolean clear() {
        return true;
    }
}
