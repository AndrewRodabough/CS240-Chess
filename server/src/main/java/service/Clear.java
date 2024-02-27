package service;

import dataAccess.AuthDAOMemory;
import dataAccess.GameDAOMemory;
import dataAccess.UserDAOMemory;

public class Clear{
    public static boolean Run() {
        dataAccess.UserDAOMemory.Clear();
        dataAccess.AuthDAOMemory.Clear();
        dataAccess.GameDAOMemory.Clear();
        return true;
    }
}
