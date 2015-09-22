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

import java.util.Objects;

/**
 *
 * @author Blackleg blackleg@openaliasbox.org
 */
public class Strings {
    
    /**
     * Check if string is null or empty
     * @param string The string
     * @return boolean
     */
    public static boolean checkIfIsEmptyOrNull(String string) {
        return Objects.isNull(string) || string.isEmpty();
 
    }

    /**
     * Check if string is not null and not empty
     * @param string The string
     * @return boolean
     */
    public static boolean checkIfIsNotEmptyOrNull(String string) {
        return !Strings.checkIfIsEmptyOrNull(string);
    }
    
    private static int contarLetras(String palabra, boolean vocales) {
        String vocalesStr = "aeiouAEIOU";
        char[] mletras = vocalesStr.toCharArray();
        char[] dividida = palabra.toCharArray();
        int n_vocales = 0;
        boolean esVocal;
        for (char letra : dividida) {
            esVocal = false;
            for (char compara : mletras) { 
                if (compara == letra) {   
                    esVocal = true;
                }
            }
            
            if(vocales && esVocal) {
                n_vocales++;
            } else if (!vocales && !esVocal)  {
                n_vocales++;
            }
        }
        return n_vocales;
    }

    /**
     * Cuenta las vocales de una string
     * @param palabra The String
     * @return Devuelve el numero de vocales
     */
    public static int contarVocales(String palabra) {
        return contarLetras(palabra, true);
    }
    
    /**
     * Cuenta las consonantes de una string
     * @param palabra The String
     * @return Devuelve el numero de consonantes
     */
    public static int contarConsonantes(String palabra) {
        return contarLetras(palabra, false);
    }
    
    /**
     * Elimina el ultimo cambio de linea de un string
     * @param texto The String
     * @return String
     */
    public static String quitarCambioLinea(String texto) {
        int length = texto.length();
        if (texto.substring(length - 1, length).equalsIgnoreCase("\n")) {   
            texto = texto.substring(0, length -1);   
        }
        return texto;  
    }
    
    /**
     * Quita un simbolo de un string
     * @param texto The text
     * @param simbolo The symbol
     * @return String
     */
    public static String quitarSimbolo(String texto,String simbolo) {
        String resultado = ""; 
        for (int i = 0; i < texto.length(); i++) {
            String temporal = texto.substring( i, i + 1);   
            if (!temporal.equals(simbolo)) {        
                resultado += temporal;
            } 
        }
        return resultado;
    }
    
    
    /**
     * [ENG] Revert String
     * [ES] Invierte una cadena.
     * @param string The string
     * @return String
     */
    public static String reverse (String string) {
        StringBuilder sb = new StringBuilder(string);
        String cadReves = sb.reverse().toString();
        return cadReves;
    }
    
    /**
     * Convierte un string en un array de enteros
     * @param s_matriz El string
     * @return int[][]
     */
    public static int[][] stringToMatrizMulti (String s_matriz) { 
        s_matriz = Strings.quitarCambioLinea(s_matriz);
        String[] filas = s_matriz.split("\n");
        int n_filas = filas.length;       
        String[] columnas = filas[0].split(" ");
        int n_columnas = Arrays.getIntegers(columnas).length;
        int[][] matriz = new int[n_filas][n_columnas];      
        for (int i = 0; i < n_filas; i++) {       
            columnas = filas[i].split(" ");   
            matriz[i] = Arrays.getIntegers(columnas); 
        }
         return matriz;
    }
}
