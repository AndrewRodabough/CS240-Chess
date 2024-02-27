package service;

import dataAccess.GameDAOMemory;

public class CreateGame{
    public static int Run(String name) {
        if(name == null) { return -1;}

        int id = GameDAOMemory.createGame(name);
        return id;
    }
}
