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
public class NotObjectInResultSetException extends Exception {

    /**
     * Creates a new instance of <code>NotObjectInResultSetException</code>
     * without detail message.
     */
    public NotObjectInResultSetException() {
    }

    /**
     * Constructs an instance of <code>NotObjectInResultSetException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotObjectInResultSetException(String msg) {
        super(msg);
    }
}
