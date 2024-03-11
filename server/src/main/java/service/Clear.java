package service;

public class Clear{
    public static boolean Run() {
        try {
            dataAccess.AuthDAOSQL.clear();
            dataAccess.UserDAOSQL.clear();
        }
        catch (Exception e) {
            return false;
        }
        dataAccess.GameDAOMemory.clear();
        return true;
    }
}
