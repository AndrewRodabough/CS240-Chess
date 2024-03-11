package service;

import dataAccess.GameDAOSQL;
import model.GameData;

import java.util.ArrayList;
import java.util.Collection;

public class ListGames{
    public static Collection<GameData> Run() {
        try {
            return GameDAOSQL.listGames();
        } catch (Exception e) {
            return new ArrayList<GameData>();
        }
    }
}
