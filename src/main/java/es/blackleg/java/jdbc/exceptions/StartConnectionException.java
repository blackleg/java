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
public class StartConnectionException extends Exception {

    /**
     * Creates a new instance of <code>StartConnectionException</code> without
     * detail message.
     */
    public StartConnectionException() {
    }

    /**
     * Constructs an instance of <code>StartConnectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StartConnectionException(String msg) {
        super(msg);
    }
}
