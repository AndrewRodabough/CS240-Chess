package service;

public class Clear{
    public static boolean Run() {
        try {
            dataAccess.AuthDAOSQL.clear();
        }
        catch (Exception e) {
            return false;
        }
        dataAccess.UserDAOMemory.clear();
        // dataAccess.AuthDAOMemory.clear();
        dataAccess.GameDAOMemory.clear();
        return true;
    }
}
