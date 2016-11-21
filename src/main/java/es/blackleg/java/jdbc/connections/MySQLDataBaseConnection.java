/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.connections;


/**
 *
 * @author alumno
 */
public class MySQLDataBaseConnection extends DatabaseConnection {  
    
    private static String defaultDriver = "com.mysql.cj.jdbc.Driver";
    private static String defaultPreConnection = "jdbc:mysql://";
    private static String defaultServerPort = "3306";
    private static String defaultServerHost = "localhost";
    private static String defaultDatabase = "mysql";
    private static String defaultConnectionFormat = "%s%s:%s/%s";
    public static final String SSL_USE = "useSSL=true";
    public static final String SSL_REQUIRED = "requireSSL=true";
    public static final String SSL_NOT_VERIFY = "verifyServerCertificate=false";
    
    public MySQLDataBaseConnection(String host, String port, String database) throws ClassNotFoundException {
        super(defaultDriver, defaultPreConnection, defaultConnectionFormat, host, port, database);
    }
    
    public MySQLDataBaseConnection(String host, String database) throws ClassNotFoundException {
        this(host, defaultServerPort, database);
    }
    
    public MySQLDataBaseConnection(String database) throws ClassNotFoundException {
        this(defaultServerHost, database);
    }
    
    public MySQLDataBaseConnection() throws ClassNotFoundException  {
        this(defaultDatabase);
    }
    
    public static MySQLDataBaseConnection makeConnection(String host, String database, String user, String password) throws ClassNotFoundException {
        MySQLDataBaseConnection dataBaseConnection = new MySQLDataBaseConnection(host, database);
        dataBaseConnection.configUser(user, password);
        return dataBaseConnection;
    }
    
    public static MySQLDataBaseConnection makeConnection(String host, String port, String database, String user, String password) throws ClassNotFoundException {
        MySQLDataBaseConnection dataBaseConnection = new MySQLDataBaseConnection(host, port, database);
        dataBaseConnection.configUser(user, password);
        return dataBaseConnection;
    }

}
