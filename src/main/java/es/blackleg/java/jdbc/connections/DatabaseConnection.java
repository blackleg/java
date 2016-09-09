/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.connections;

import es.blackleg.java.utilities.Strings;
import es.blackleg.java.jdbc.exceptions.CloseConnectionException;
import es.blackleg.java.jdbc.exceptions.MakePreparedException;
import es.blackleg.java.jdbc.exceptions.QuerryException;
import es.blackleg.java.jdbc.exceptions.SelectException;
import es.blackleg.java.jdbc.exceptions.StartConnectionException;
import es.blackleg.java.jdbc.exceptions.TableException;
import es.blackleg.java.utilities.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database Connection
 * @author blackleg
 */
public class DatabaseConnection {
    
    private Connection connection;
    
    private Statement statement; 
    
    private String driver;
    
    private String preConnection;
    
    private String connectionFormat;
    
    private String host;
    
    private String port;
    
    private String database;
    
    private String user;
    
    private String password;

    public DatabaseConnection(String driver, String preConnection, String connectionFormat, String host, String port, String database) throws ClassNotFoundException {
        this.driver = driver;
        Class.forName(this.driver);
        this.preConnection = preConnection;
        this.connectionFormat = connectionFormat;
        this.host = host;
        this.port = port;
        this.database = database;
    }
    
    public DatabaseConnection(Connection connection) {
        this.connection = connection;
    }
    
    public static DatabaseConnection newConnection(Connection connection) {
        return new DatabaseConnection(connection);
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     * @throws java.lang.ClassNotFoundException
     */
    public void setDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.driver = driver;
    }

    /**
     * @return the preConnection
     */
    public String getPreConnection() {
        return preConnection;
    }

    /**
     * @param preConnection the preConnection to set
     */
    public void setPreConnection(String preConnection) {
        this.preConnection = preConnection;
    }

    public String getConnectionFormat() {
        return connectionFormat;
    }

    public void setConnectionFormat(String connectionFormat) {
        this.connectionFormat = connectionFormat;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void configUser(String user, String password) {
        this.setUser(user);
        this.setPassword(password);
    }
    
    private String makeConnection() {
        return String.format(connectionFormat, preConnection, host, port, database);
    }
    
    public void startConnection() throws StartConnectionException {
        try {
            connection = getConnection();
            statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            try {
                this.closeConnection();
            } catch (CloseConnectionException closeExcep) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, closeExcep);
            }
            throw new StartConnectionException(ex.getMessage());
        }
    }
    
    
    public void closeConnection() throws CloseConnectionException {
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new CloseConnectionException(ex.getMessage());
        }
    }
    
    public ResultSet executeQuery(String query) throws QuerryException {
        try {
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            throw new QuerryException(ex.getMessage());
        }
    }
    
    public ResultSet executeSelect(String select, String from, String where, String groupby, String having, String orderby) throws TableException, SelectException {
        String querry = "Select %s from %s";
        if(Strings.checkIfIsEmptyOrNull(from)) {
            throw new TableException(from);
        } else {
            if(Strings.checkIfIsEmptyOrNull(select)) {
                querry = String.format(querry, "*" , from);
            } else {
                querry = String.format(querry, select , from);
            }
            if (!Strings.checkIfIsEmptyOrNull(where)) {
                querry = querry.concat(String.format(" where %s", where));
            }
            if (!Strings.checkIfIsEmptyOrNull(groupby)) {
                querry = querry.concat(String.format(" group by %s", groupby));
                if(!Strings.checkIfIsEmptyOrNull(having)) {
                    querry = querry.concat(String.format(" having %s", having));
                }
            }
            if (!Strings.checkIfIsEmptyOrNull(orderby)) {
                querry = querry.concat(String.format(" order by %s", orderby));
            }
            try {
                return this.executeQuery(querry);
            } catch (QuerryException ex) {
                throw new SelectException(ex.getMessage());
            }
        }
    }
    
    public ResultSet executeSelect(String select, String from, String where, String groupby, String having) throws TableException, SelectException {
        return this.executeSelect(select, from, where, groupby, having, null);
    }
    
    public ResultSet executeSelect(String select, String from, String where, String groupby) throws TableException, SelectException {
        return this.executeSelect(select, from, where, groupby, null);
    }
    
    public ResultSet executeSelect(String select, String from, String where) throws TableException, SelectException {
        return this.executeSelect(select, from, where, null);
    }
    
    public ResultSet executeSelect(String select, String from) throws TableException, SelectException {
        return this.executeSelect(select, from, null);
    }
    
    public ResultSet executeSelect(String from) throws TableException, SelectException {
        return this.executeSelect(null, from);
    }
    
    public PreparedStatement makePreparedStatement(String querry) throws MakePreparedException {
        try {
            return connection.prepareStatement(querry);
        } catch (SQLException ex) {
            throw new MakePreparedException(ex.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            return DriverManager.getConnection(makeConnection(), user, password);
        } else {
            return connection;
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}

