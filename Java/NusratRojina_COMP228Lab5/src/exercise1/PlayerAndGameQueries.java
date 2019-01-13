package exercise1;


import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class PlayerAndGameQueries {

    private PreparedStatement checkPlayerExists;
    private PreparedStatement checkGameIdExists;
    private PreparedStatement checkIfPlayerExists;
    private PreparedStatement selectAll;
    private PreparedStatement selectGame;
    private PreparedStatement selectPlayer;
    private PreparedStatement getPlayersById;
    private PreparedStatement insertNewPlayerAndGame;
    private PreparedStatement insertNewPlayer;
    private PreparedStatement insertNewGame;
    private PreparedStatement updatedGame;
    private PreparedStatement updatedPlayer;
    private PreparedStatement updatedPlayerAndGame;
    private PreparedStatement deleteGame;
    private PreparedStatement deletePlayer;
    private PreparedStatement deletePlayerAndGame;
    private ResultSet resultSet;




    public Connection connection;

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABSE_URL = "jdbc:sqlserver://localhost:1433;database=Games;integratedSecurity=true";

    // constructor
    public PlayerAndGameQueries(){

        // Initializes the connection with the SQL database
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABSE_URL);
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }

    }

    //Returns all records in the Game table as an ArrayList
    public ObservableList<PlayerAndGame> getAllList() {
        // temp variables
        ObservableList<PlayerAndGame> player_Game_List = null;
        player_Game_List = FXCollections.observableArrayList();
        //PlayerAndGame playerAndGameRecord;
        resultSet = null;

        try {
            selectAll = connection.prepareStatement("select g.*, p.*, pg.* from PlayerAndGame pg inner join Game g on pg.game_id = g.game_id inner join Player p on pg.player_id = p.player_id");
            resultSet = selectAll.executeQuery();

            while (resultSet.next()) {

                player_Game_List.add(new PlayerAndGame(resultSet.getInt("game_id"),
                        resultSet.getString("game_title"), resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),resultSet.getString("last_name"),
                        resultSet.getString("address"),resultSet.getString("postal_code"),
                        resultSet.getString("province"),resultSet.getString("phone_number"),
                        resultSet.getString("playing_date"),resultSet.getString("score")));

            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }

        return player_Game_List;
    }


    //return true if a game is found with the same title, false otherwise
    private boolean checkIfAGameExists(int gameId) {
        try {
            checkGameIdExists = connection.prepareStatement(
                    "select * from Game where game_id = ?");
            checkGameIdExists.setInt(1, gameId);
            resultSet = checkGameIdExists.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException sqlException) {
            return false;
        }
    }

    //return true if a player is found with the same id, name , false otherwise
    private boolean checkIfAPlayerExists(int playerId) {
        try {
            checkIfPlayerExists = connection.prepareStatement(
                    "select * from Player where player_id = ?");
            checkIfPlayerExists.setInt(1,playerId);
            resultSet = checkIfPlayerExists.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException sqlException) {
            return false;
        }
    }


    // add new entry
    public int insertIntoPlayerAndGame(int playerId,
                                       int gameId, String playingDate,String score) {
        int result = 0;

        //  set parameters, then execute insertNewGame
        try {
            if(this.checkIfAGameExists(gameId) && this.checkIfAPlayerExists(playerId)) {

                insertNewPlayerAndGame = connection.prepareStatement("insert into PlayerAndGame (game_id,player_id,playing_date,score) values(?,?,?,?)");

                insertNewPlayerAndGame.setInt(1, gameId);
                insertNewPlayerAndGame.setInt(2, playerId);
                insertNewPlayerAndGame.setString(3,playingDate);
                insertNewPlayerAndGame.setString(4, score);
                result = insertNewPlayerAndGame.executeUpdate();

                return result;
            }

            return 0;

        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public int insertIntoPlayer(int playerId,String firstName,String lastName,String address,
                                       String postalCode,String province,String phoneNumber) {
        int result = 0;

        //  set parameters, then execute insertNewGame
        try {

            if(!this.checkIfAPlayerExists(playerId)){
            insertNewPlayer = connection.prepareStatement("insert into Player (player_id,first_name,last_name,address,postal_code,province,phone_number) values(?,?,?,?,?,?,?)");
                insertNewPlayer.setInt(1,playerId);
                insertNewPlayer.setString(2, firstName);
                insertNewPlayer.setString(3, lastName);
                insertNewPlayer.setString(4, address);
                insertNewPlayer.setString(5, postalCode);
                insertNewPlayer.setString(6, province);
                insertNewPlayer.setString(7, phoneNumber);

                result = insertNewPlayer.executeUpdate();
            return result;
        }

        return 0;

    } catch (Exception sqlException) {
        sqlException.printStackTrace();
        close();

    }
        return result;
}
    public int insertIntoGame(int gameId,String gameTitle) {
        int result = 0;

        //  set parameters, then execute insertNewGame
        try {

            if (!this.checkIfAGameExists(gameId)) {
                insertNewGame = connection.prepareStatement("insert into Game (game_id,game_title) values(?,?)");
                insertNewGame.setInt(1, gameId);
                insertNewGame.setString(2, gameTitle);
                result = insertNewGame.executeUpdate();
                return result;
            }

            return 0;

        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            close();

        }
        return result;
    }


    /*Updates the row in the PlayerAndGame table that has matching details as the parameters
      according to the player_game_id*/

    public int updatePlayerAndGame(int playerId,String firstName,String lastName,String address,
                                    String postalCode,String province,String phoneNumber,int gameId,String gameTitle,String playingDate,String score) {

        int result = 0;
        try {

            try (PreparedStatement updatedPlayerAndGame = connection.prepareStatement("update Game set game_id = ?,game_title = ? where game_id = ?")){

                updatedPlayerAndGame.setInt(1, gameId);
                updatedPlayerAndGame.setString(2, gameTitle);
                updatedPlayerAndGame.setInt(3, gameId);
                updatedPlayerAndGame.executeUpdate();

            }

            try (PreparedStatement updatedPlayerAndGame = connection.prepareStatement("update Player set player_id = ?,first_name = ?, last_name = ?, address=?,postal_code=?, province=?, phone_number=? where player_id = ?")){

                updatedPlayerAndGame.setInt(1, playerId);
                updatedPlayerAndGame.setString(2, firstName);
                updatedPlayerAndGame.setString(3, lastName);
                updatedPlayerAndGame.setString(4, address);
                updatedPlayerAndGame.setString(5, postalCode);
                updatedPlayerAndGame.setString(6, province);
                updatedPlayerAndGame.setString(7, phoneNumber);
                updatedPlayerAndGame.setInt(8, playerId);
                updatedPlayerAndGame.executeUpdate();
            }


            try (PreparedStatement updatedPlayerAndGame = connection.prepareStatement("update PlayerAndGame set player_id = ?, game_id = ?, playing_date = ?,score= ? where player_id = ? and game_id = ?")) {

                updatedPlayerAndGame.setInt(1, playerId);
                updatedPlayerAndGame.setInt(2, gameId);
                updatedPlayerAndGame.setString(3,playingDate);
                updatedPlayerAndGame.setString(4, score);
                updatedPlayerAndGame.setInt(5, playerId);
                updatedPlayerAndGame.setInt(6, gameId);
                updatedPlayerAndGame.executeUpdate();
            }


        }
        catch (Exception sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }


    /* Deletes the record matching the parameters from the PlayerAndGame table according to the player_game_id*/

    public int deletePlayerAndGame(int playerId, int gameId) {
        int result = 0;
        try {
            // remove all records from PlayerAndGame that include this Game

            deletePlayerAndGame = connection.prepareStatement("delete from PlayerAndGame where player_id = ? and game_id =?");
            deletePlayerAndGame.setInt(1,playerId);
            deletePlayerAndGame.setInt(2,gameId);

            result = deletePlayerAndGame.executeUpdate();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

        return result;

    }

    public int deletePlayer(int playerId) {
        int result = 0;
        try {
            // remove all records from Player that include this playerId

            deletePlayer = connection.prepareStatement("delete from Player where player_id = ?");
            deletePlayer.setInt(1,playerId);
            deletePlayer.executeUpdate();

            deletePlayerAndGame = connection.prepareStatement("delete from PlayerAndGame where player_id = ?");
            deletePlayerAndGame.setInt(1, playerId);
            deletePlayerAndGame.executeUpdate();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

        return result;

    }
    public int deleteGame(int gameId) {
        int result = 0;
        try {
            // remove all records from Player that include this playerId

            deletePlayer = connection.prepareStatement("delete from Game where game_id = ?");
            deletePlayer.setInt(1,gameId);
            deletePlayer.executeUpdate();


            deletePlayerAndGame = connection.prepareStatement("delete from PlayerAndGame where game_id = ?");
            deletePlayerAndGame.setInt(1, gameId);
            deletePlayerAndGame.executeUpdate();




        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

        return result;

    }



//select player by id
    public int[] getPlayerById() {

        ObservableList<Integer> playerIdList = null;
        int[] playerIdArray = null;
        resultSet = null;
        try {
            getPlayersById = connection.prepareStatement(
                    "select player_id from Player");

            // execute query returns ResultSet containing matching entries
            resultSet = getPlayersById.executeQuery();
            playerIdList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                playerIdList.add(resultSet.getInt("player_id"));
                playerIdArray = new int[playerIdList.size()];
                for(int i = 0; i < playerIdArray.length; i++)
                    playerIdArray[i] = playerIdList.get(i);
            }

        }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }

        return playerIdArray;

    }

    // return list of all games not yet added to the player
    public int[] getAllGamesOfAPlayer(int playerId) {

        int[] gameArray = null;
        ObservableList<Integer> gameList = null;
        resultSet = null;
        try {
            selectGame = connection.prepareStatement(
                    "select game_id from PlayerAndGame where player_id = ?");
            selectGame.setInt(1, playerId);
            resultSet = selectGame.executeQuery();
            gameList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                gameList.add(resultSet.getInt("game_id"));
                gameArray = new int[gameList.size()];
                for(int i = 0; i < gameArray.length; i++)
                    gameArray[i] = gameList.get(i);
            }


        } catch (SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }

        return gameArray;
    }

    public void close() {
        try {
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }


}
