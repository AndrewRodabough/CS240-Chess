package dataAccess;

import chess.ChessGame;
import model.GameData;
import model.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import com.google.gson.Gson;

public class GameDAOSQL {
    public static int createGame(String gameName) throws DataAccessException {
        if(nameExists(gameName)) {return -1; }

        Random random = new Random();
        int num;
        do {
            // generate a unique 6 digit number from 100000-999999 for id
            num = 100000 + random.nextInt(900000);
        } while (idExists(num));

        ChessGame game = new ChessGame();
        Gson gson = new Gson();

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "INSERT into game (gameID, gameName, game) VALUES (?,?,?)";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.setInt(1, num);
                    preparedStatement.setString(2, gameName);
                    preparedStatement.setString(3, gson.toJson(game));
                    preparedStatement.execute();
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }
        return 1;
    }
    public static boolean idExists(int id) throws DataAccessException {
        return getGame(id) != null;
    }
    public static boolean nameExists(String name) throws DataAccessException {
        GameData game = null;

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement2 = "SELECT * FROM game WHERE gameName = ?";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                    preparedStatement.setString(1, name);
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String gameJson = resultSet.getString("gameName");
                            Gson gson = new Gson();
                            ChessGame gameO = gson.fromJson(gameJson, ChessGame.class);
                            game = new GameData(resultSet.getInt("gameID"),
                                    resultSet.getString("whiteUsername"),
                                    resultSet.getString("blackUsername"),
                                    resultSet.getString("gameName"),
                                    gameO
                            );
                        }
                    }
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }

        return game != null;
    }
    public static GameData getGame(int id) throws DataAccessException{
        GameData game = null;

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement2 = "SELECT * FROM game WHERE gameID = ?";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                    preparedStatement.setInt(1, id);
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String gameJson = resultSet.getString("gameName");
                            Gson gson = new Gson();
                            ChessGame gameO = gson.fromJson(gameJson, ChessGame.class);
                            game = new GameData(resultSet.getInt("gameID"),
                                    resultSet.getString("whiteUsername"),
                                    resultSet.getString("blackUsername"),
                                    resultSet.getString("gameName"),
                                    gameO
                                    );
                        }
                    }
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }

        return game;
    }
    public static Collection<GameData> listGames() throws DataAccessException {
        List<GameData> games = new ArrayList<>();

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement2 = "SELECT * FROM game";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        while(resultSet.next()) {
                            String gameJson = resultSet.getString("gameName");
                            Gson gson = new Gson();
                            ChessGame gameO = gson.fromJson(gameJson, ChessGame.class);

                            GameData game = new GameData(resultSet.getInt("gameID"),
                                    resultSet.getString("whiteUsername"),
                                    resultSet.getString("blackUsername"),
                                    resultSet.getString("gameName"),
                                    gameO
                            );
                            games.add(game);
                        }
                    }
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }

        return games;
    }
    public static boolean updateGameUser(int id, String whiteUsername, String blackUsername) throws DataAccessException {

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            GameData game = getGame(id);
            if(game == null) { return false; }

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                if (whiteUsername != null) {
                    String statement2 = "UPDATE game SET whiteUsername = ? WHERE gameID = ?";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                        preparedStatement.setString(1, whiteUsername);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                    }
                }
                if (blackUsername != null) {
                    String statement2 = "UPDATE game SET blackUsername = ? WHERE gameID = ?";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                        preparedStatement.setString(1, blackUsername);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                    }
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }
        return true;
    }
    public static boolean clear() throws DataAccessException, SQLException {
        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "DELETE FROM game";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.execute();
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }
        return true;
    }
}
