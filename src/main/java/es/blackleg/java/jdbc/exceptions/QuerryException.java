/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.exceptions;

/**
 *
 * @author hector
 */
public class QuerryException extends Exception {

    /**
     * Creates a new instance of <code>QuerryException</code> without detail
     * message.
     */
    public QuerryException() {
    }

    /**
     * Constructs an instance of <code>QuerryException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public QuerryException(String msg) {
        super(msg);
    }
}
