package dataAccess;

import model.UserData;

abstract class UserDAOInterface implements DAOInterface {
    static boolean CreateUser(UserData user) { return false; }
    static UserData GetUser(String username) { return null; }
    public static boolean Clear() {
        return true;
    }
}
