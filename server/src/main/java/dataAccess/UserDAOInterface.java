package dataAccess;

abstract class UserDAOInterface implements DAOInterface {
    abstract void CreateUser();
    abstract void GetUser();
}
