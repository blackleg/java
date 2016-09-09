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
public class CloseConnectionException extends Exception {

    /**
     * Creates a new instance of <code>CloseConnectionException</code> without
     * detail message.
     */
    public CloseConnectionException() {
    }

    /**
     * Constructs an instance of <code>CloseConnectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CloseConnectionException(String msg) {
        super(msg);
    }
}
