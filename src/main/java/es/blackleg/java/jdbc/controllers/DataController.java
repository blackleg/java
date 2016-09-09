/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.controllers;

import es.blackleg.java.jdbc.connections.DatabaseConnection;
import es.blackleg.java.jdbc.exceptions.CloseConnectionException;
import es.blackleg.java.jdbc.exceptions.MakePreparedException;
import es.blackleg.java.jdbc.exceptions.NotObjectInResultSetException;
import es.blackleg.java.jdbc.exceptions.SelectException;
import es.blackleg.java.jdbc.exceptions.StartConnectionException;
import es.blackleg.java.jdbc.exceptions.TableException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author hector
 * @param <T> Type of DatabaseConnection
 * @param <S> Type of Object To Controll
 */
public abstract class DataController<T extends DatabaseConnection, S extends Object> {
    
    private static final String DEFAULTSELECT = "select * from %s";
    
    private T dataBaseConnection;
    
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private ResultSet resultSet;
    
    private String table;
    
    /**
     * DataController Abstract
     * @param dataBaseConnection
     * @param table
     */
    public DataController(T dataBaseConnection, String table) {
        this.dataBaseConnection = dataBaseConnection;
        this.table = table;
    }
    

    public void setDataBaseConnection(T dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public T getDataBaseConnection() {
        return dataBaseConnection;
    }

    public void setTable(String table) throws TableException, SelectException {
        this.table = table;
        this.updateObjects();
        
    }

    public String getTable() {
        return table;
    }
    
    
    /**
     * Habilita el data controller
     * @throws StartConnectionException
     * @throws es.blackleg.java.jdbc.exceptions.TableException
     * @throws es.blackleg.java.jdbc.exceptions.SelectException
     */
    public void enable() throws StartConnectionException, TableException, SelectException  {
        dataBaseConnection.startConnection();
        resultSet = dataBaseConnection.executeSelect(table);
    }
    
    /**
     * Deshabilita el data controller
     * @throws CloseConnectionException
     */
    public void disable() throws CloseConnectionException {
        dataBaseConnection.closeConnection();
    }

    protected ResultSet getResultSet() {
        return resultSet;
    }

    protected void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void setPreparedInsert(String insert) throws MakePreparedException {
        this.insert = dataBaseConnection.makePreparedStatement(insert);
    }

    public void setPreparedDelete(String delete) throws MakePreparedException {
        this.delete = dataBaseConnection.makePreparedStatement(delete);
    }

    public void setPreparedUpdate(String update) throws MakePreparedException {
        this.update = dataBaseConnection.makePreparedStatement(update);
    }

    public void setPreparedSelect(String select) throws MakePreparedException {
        this.select = dataBaseConnection.makePreparedStatement(select);
    }

    protected ArrayList<S> getObjectsFromResultSet(ResultSet resultSet) throws SQLException {
        return this.getObjects(resultSet);
    }
    
    private  ArrayList<S> getObjects(ResultSet resultSet) throws SQLException {
        ArrayList<S> dataObjects = new ArrayList<>();
        dataObjects.clear();
        resultSet.beforeFirst();
        while (resultSet.next()) {   
            dataObjects.add(getObjectFromDatabase(resultSet));
        }
        return dataObjects;
    }
    /**
     * Actualiza el ResultSet
     * @throws TableException
     * @throws SelectException
     */
    public void updateObjects() throws TableException, SelectException {
        resultSet = dataBaseConnection.executeSelect(table);
    }
    
    /**
     * Mueve el puntero del resulset hasta el objeto indicado.
     * @param object
     * @throws NotObjectInResultSetException
     * @throws SQLException
     */
    public void moveToObject(S object) throws NotObjectInResultSetException, SQLException {
        if (Objects.nonNull(object)) {
            S temporal = this.firstObject();
            while(!object.equals(temporal)) {
                temporal = this.nextObject();
            }
        } 
    }
    
    /**
     * Devuelve un ArrayList con los objetos del ResultSet
     * @return
     * @throws SQLException
     */
    public ArrayList<S> getObjects() throws SQLException {
        return this.getObjects(resultSet);
    }

    
    public ArrayList<S> preparedSelect() throws SQLException {
        return this.getObjects(select.executeQuery());
    }
    
    public void preparedInsert(S object) throws SQLException {
        if (Objects.nonNull(object)) {
            setObjectInInsertPrepared(insert, object);
            insert.execute();
        }
    }
    
    protected abstract void setObjectInInsertPrepared(PreparedStatement insert, S object) throws SQLException;
    
    public void preparedDelete(S object) throws SQLException {
        if (Objects.nonNull(object)) {
            setObjectInDeletePrepared(delete, object);
            delete.execute(); 
        }
    }
    
    protected abstract void setObjectInDeletePrepared(PreparedStatement delete, S object);
    
    public void preparedUpdate(S object) throws SQLException {
        if (Objects.nonNull(object)) {
            setObjectInUpdatePrepared(update, object);
            update.execute(); 
        }
    }
    
    protected abstract void setObjectInUpdatePrepared(PreparedStatement update, S object);
    
    protected abstract S getObjectFromDatabase(ResultSet resultSet) throws SQLException;
    
    public S firstObject() throws SQLException, NotObjectInResultSetException {
        if (resultSet.first()) {
            return getObjectFromDatabase(resultSet); 
        } else {
            throw new NotObjectInResultSetException();
        }
    }
    
    public S lastObject() throws SQLException, NotObjectInResultSetException {
        if (resultSet.last()) {
            return getObjectFromDatabase(resultSet); 
        } else {
            throw new NotObjectInResultSetException();
        }
    }
    
    public S nextObject() throws SQLException, NotObjectInResultSetException {
        if(!resultSet.isLast() && resultSet.next()) {
            return getObjectFromDatabase(resultSet);
        } else {
            throw new NotObjectInResultSetException();
        }
    }
    
    public S previousObject() throws SQLException, NotObjectInResultSetException {
        if(!resultSet.isFirst() && resultSet.previous()) {
            return getObjectFromDatabase(resultSet);
        } else {
            throw new NotObjectInResultSetException();
        }
    }
    
    /**
     * Borra el objeto que encuentre igual que el del parametro
     * @param object
     * @throws NotObjectInResultSetException
     * @throws SQLException
     */
    public void deleteObject(S object) throws NotObjectInResultSetException, SQLException {
        moveToObject(object);
        deleteObject();
    }
    
    private void deleteObject() throws SQLException, NotObjectInResultSetException { 
        if (resultSet.getRow() == 0) {
            throw new NotObjectInResultSetException();
        } else {
            resultSet.deleteRow();
            if (resultSet.isBeforeFirst()) {
                this.nextObject();
            } else {
                this.previousObject();
            }
        } 
    }
    
    /**
     * Inserta un nuevo objeto en el ResultSet
     * @param object
     * @throws SQLException
     * @throws NotObjectInResultSetException
     */
    public void newObject(S object) throws SQLException, NotObjectInResultSetException {
        resultSet.moveToInsertRow();
        this.insertObjectInResultset(object, resultSet);
        resultSet.insertRow();
        this.lastObject();
    }

    protected abstract void insertObjectInResultset(S object, ResultSet resultSet) throws SQLException;
    
    /**
     * Search oldObject and update this
     * @param oldObject
     * @param newObject
     * @throws SQLException
     * @throws NotObjectInResultSetException
     */
    public void updateObject(S oldObject, S newObject) throws SQLException, NotObjectInResultSetException {
        moveToObject(oldObject);
        updateObject(newObject);
    }
    
    private void updateObject(S object) throws SQLException {
        this.updateObjectInResultSet(resultSet, object);
        resultSet.updateRow();
    }

    protected abstract void updateObjectInResultSet(ResultSet resultSet, S object) throws SQLException;
    
    
    
}
