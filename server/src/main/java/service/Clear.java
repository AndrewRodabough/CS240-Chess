package service;

public class Clear{
    public static boolean Run() {
        try {
            dataAccess.AuthDAOSQL.clear();
            dataAccess.UserDAOSQL.clear();
            dataAccess.GameDAOSQL.clear();
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
}
