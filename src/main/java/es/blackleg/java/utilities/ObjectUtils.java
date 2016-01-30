/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.blackleg.java.utilities;

import java.util.Objects;
/**
 *
 * @author hector
 */
public class ObjectUtils {
    
    public static boolean checkTwoObjectsNonNull(Object objectOne, Object objectTwo) {
        return Objects.nonNull(objectOne) && Objects.nonNull(objectTwo);
    }
    
}
