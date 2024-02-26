package dataAccess;

abstract class GameDAOInterface implements DAOInterface{
    abstract void CreateGame();
    abstract void GetGame();
    abstract void ListGames();
    abstract void UpdateGame();
}
