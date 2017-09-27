package nl.arbro.tictactoe.model;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created By: arbro
 * Date: 28-8-17 - 12:31
 * Project: tictactoe
 **/

public class TicTacToeDbConnection {

    private static TicTacToeDbConnection instance = null;
    private Connection conn = null;


    private TicTacToeDbConnection(){
    }

    public static TicTacToeDbConnection getInstance(){
        if (instance == null) {
            synchronized (TicTacToeDbConnection.class) {
                if (instance == null) {
                    instance = new TicTacToeDbConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        Properties prop = new Properties();
        ClassLoader loader =  Thread.currentThread().getContextClassLoader();

        try (InputStream input = loader.getResourceAsStream("tictactoedb.properties")) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop);
        return conn;
    }

}
