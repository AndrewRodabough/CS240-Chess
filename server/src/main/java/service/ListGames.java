package service;

import dataAccess.GameDAOMemory;
import model.GameData;

import java.util.Collection;

public class ListGames{
    public static Collection<GameData> Run() {
        return GameDAOMemory.listGames();
    }
}
