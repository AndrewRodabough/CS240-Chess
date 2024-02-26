package dataAccess;

abstract class AuthDAOInterface implements DAOInterface {
    abstract void CreateAuth();
    abstract void GetAuth();
    abstract void DeleteAuth();
}
