package service;

import dataAccess.GameDAOSQL;

public class CreateGame{
    public static int Run(String name) {

        if(name == null) { return -1;}
        try {
            int id = GameDAOSQL.createGame(name);
            return id;
        }
        catch (Exception e) {
            return -1;
        }

        /*
        if(name == null) { return -1;}

        int id = GameDAOMemory.createGame(name);
        return id;
        */
    }
}
