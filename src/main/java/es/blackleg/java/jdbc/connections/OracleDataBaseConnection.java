/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.connections;


/**
 *
 * @author hector
 */
public class OracleDataBaseConnection extends DatabaseConnection { 
    
    private static String defaultDriver = "oracle.jdbc.driver.OracleDriver";
    private static String defaultPreConnection = "jdbc:oracle:thin:";
    private static String defaultServerPort = "1521";
    private static String defaultServerHost = "localhost";
    private static String defaultDatabase = "public";
    private static String defaultConnectionFormat = "%s@%s:%s:%s";
    
    public OracleDataBaseConnection(String host, String port, String database) throws ClassNotFoundException {
        super(defaultDriver, defaultPreConnection, defaultConnectionFormat,host, port, database);
    }
    
    public OracleDataBaseConnection(String host, String database) throws ClassNotFoundException {
        this(host, defaultServerPort, database);
    }
    
    public OracleDataBaseConnection(String database) throws ClassNotFoundException {
        this(defaultServerHost, database);
    }
    
    public OracleDataBaseConnection() throws ClassNotFoundException  {
        this(defaultDatabase);
    }    
  
}
