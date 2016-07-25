import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kmhasan
 */
public class LoginService {
    private Map<String, User> userMap;
    
    public static String getDB_URL() {
        return DB_URL;
    }

    public static String getDB_USER() {
        return DB_USER;
    }

    public static String getDB_PASS() {
        return DB_PASS;
    }

    private Connection connection;
    private Statement statement;
    private static final String DB_URL = "jdbc:mysql://172.17.0.134/logindb";
    private static final String DB_USER = "cse4047";
    private static final String DB_PASS = "java";

    public LoginService() {
        userMap = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean authenticate(String username, String password) {
        String query = "select * from Login where username='" + username + "' and password = md5('" + password + "');";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String user = resultSet.getString("username");
            String full = resultSet.getString("fullname");
            if (user.equals(username)) {
                User userObject = new User(user, full);
                userMap.put(username, userObject);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public User getUserDetails(String username) {
        return userMap.get(username);
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
