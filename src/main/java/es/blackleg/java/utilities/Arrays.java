/*
 * Copyright 2015 Blackleg blackleg@openaliasbox.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.blackleg.java.utilities;

/**
 *
 * @author Blackleg blackleg@openaliasbox.org
 */
public class Arrays {
 
    
     /**
     * Convert array in a String 
     * @param array The array to convert
     * @return String the converted array
     */
    public static String toText (String[] array) {
        String cadena = "";
        for (String palabra : array) {
            cadena += palabra + " ";
        }
        return cadena;
    }
    
    /**
     * Convert array in a String 
     * @param array The array to convert
     * @return String the converted array
     */
    public static String toText (int[] array) {
        String cadena = "";
        for (int numero : array) { 
            cadena += Integer.toString(numero) + " ";
        }
        return cadena;
    }
    
    
    /**
     * Convert array in a String 
     * @param array The array to convert
     * @return String the converted array
     */
    public static String toText (char[] array) {
        String cadena = "";
        for (char letra : array) {  
            cadena += String.valueOf(letra);
        }
        return cadena;
    }
}
