package pl.lublin.wsei.java.cwiczenia;

import java.sql.*;
import java.util.Properties;

public class MyDB {
    private Connection conn = null;
    private Statement statement = null;
    private String user;
    private String password;
    private String host;
    private Number port;
    private String dbName;

    public MyDB(String _host, Number _port, String _dbName) {
        this.host = _host;
        this.port = _port;
        this.dbName = _dbName;
    }

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "123456789zxc");
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println();
            System.out.println();
            conn = null;
        }
        System.out.println("Connected to database " + dbName);
    }

    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void closeConnection(){
        if(conn != null)
            try{
                conn.close();
            }catch (SQLException e){
                System.out.println("Blad przy zamykaniu polazczenia bazodanowego: " + e.getMessage());
            }
        conn = null;
    }

    public ResultSet selectData(String selectStatement){
        if((conn != null) && (statement != null))
            try{
                return statement.executeQuery(selectStatement);
            }catch (SQLException e){
                System.out.println("Blad realizacji zapytania: " + selectStatement + ", " + e.getMessage());
            }
        return null;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
