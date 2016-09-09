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
public class TableException extends Exception {

    /**
     * Creates a new instance of <code>TableException</code> without detail
     * message.
     */
    public TableException() {
    }

    /**
     * Constructs an instance of <code>TableException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public TableException(String msg) {
        super(msg);
    }
}
