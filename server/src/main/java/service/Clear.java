package service;

public class Clear{
    public static Object Run() {
        boolean result = false;
        result = (boolean) dataAccess.UserDAOMemory.Clear();
        if (!result) { return false; }
        result = (boolean) dataAccess.AuthDAOMemory.Clear();
        if (!result) { return false; }
        result = (boolean) dataAccess.GameDAOMemory.Clear();
        return result;
    }
}
