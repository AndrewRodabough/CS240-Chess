package service;

public class Clear{
    public static boolean Run() {
        dataAccess.UserDAOMemory.clear();
        dataAccess.AuthDAOMemory.clear();
        dataAccess.GameDAOMemory.clear();
        return true;
    }
}
