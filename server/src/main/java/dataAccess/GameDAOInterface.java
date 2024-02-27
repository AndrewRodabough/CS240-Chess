package dataAccess;

abstract class GameDAOInterface implements DAOInterface{
    static void CreateGame() {}
    static void GetGame() {}
    static void ListGames() {}
    static void UpdateGame() {}
    public static boolean Clear() {
        return true;
    }
}
