/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.jdbc.exceptions;

/**
 *
 * @author alumno
 */
public class MakePreparedException extends Exception {

    /**
     * Creates a new instance of <code>MakePreparedException</code> without
     * detail message.
     */
    public MakePreparedException() {
    }

    /**
     * Constructs an instance of <code>MakePreparedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MakePreparedException(String msg) {
        super(msg);
    }
}
