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
     * Devuelve un String de una matriz de objetos.
     * @param array The array to convert
     * @return String
     */
    public static String toText (Object[] array) {
        String cadena = "";
        for (Object palabra : array) { 
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
    
    /**
     * Convierte una matriz en una cadena
     * @param array The array to convert
     * @return String the converted array
     */
    public static String toText (double[] array) {
        String cadena = "";
        for (double numero : array) {
            cadena += Double.toString(numero) + " ";
        }
        return cadena;
    }
    
    /**
     * Convierte una matriz en una cadena
     * @param array The array to convert
     * @return String the converted array
     */
    public static String toText (int[][] array) { 
        String cadena = "";
        try {
            for (int[] matriz1 : array) {
                for (int columna = 0; columna < matriz1.length; columna++) {
                    cadena += String.format("%2d ", matriz1[columna]);
                }
                cadena += "\n";
            }
        } catch (NullPointerException e) {
            cadena = "NULL";
        }
        return cadena;
    }
    
    /**
     * Extrae el número mayor de una matriz de enteros
     * @param matriz An Array
     * @return int
     */  
    public static int getHigher(int[] matriz) {
        int mayor = matriz[0];
        for (int numero : matriz) {
            if (numero > mayor) {
                mayor = numero;
            }     
        }
        return mayor;
    }
    
    /**
     * Extrae el valor menor de una matriz de enteros
     * @param matriz A Array
     * @return int
     */
    public static int getMinor(int[] matriz) {
        int menor = matriz[0];
        for (int numero : matriz) {
            if (numero < menor) {
                
                menor = numero;
            }     
        }
        return menor;
    }
    
    /**
     * Extrae el numero mayor de una matriz de dobles
     * @param matriz An Array
     * @return double
     */
    public static double getHigher(double[] matriz) {
        double mayor = 0;
        for (double numero : matriz) {
            if (numero > mayor) { 
                mayor = numero;
            }     
        }
        return mayor;
    }
    
    /**
     * Extrae el valor menor de un array de doubles
     * @param array An Array
     * @return double
     */
    public static double getMinor(double[] array) {
        double menor = 0;
        for (double numero : array) {
            if (numero < menor) {
                menor = numero;
            }     
        }
        return menor;
    }
    
    /**
     * Cuenta el numero de pares en un array.
     * @param array The Array
     * @return int
     */
    public static int countPares(int[] array) {
        int pares = 0;
        for (int numero : array) {
            if (Calculator.esPar(numero)) {
                pares++;
            }
        }   
        return pares;
    }
    
    
    /**
     * Cuenta el numero de pares en un array.
     * @param array The Array
     * @return int
     */
    public static int contadorImpares(int[] array) {
        int impares = 0;
        for (int numero : array) {
            if (Calculator.esImpar(numero)) {
                impares++;
            }
        }   
        return impares;
    }
    
    /**
     * Convierte los valores de un array de enteros en pares o impares.
     * @param array The array
     * @param pares True pasa a pares, false a impares
     * @return Devuelve una matriz de enteros
     */
    public static int[] convertir (int[] array, boolean pares) {
        int[] matrizconvertidos = new int[array.length]; 
        for (int i = 0; i < array.length; i++) {
            int numero = array[i];
            if (pares) {
                if (Calculator.esImpar(numero)) {
                    if(numero + 1 > 99) {
                        matrizconvertidos[i] = numero - 1;
                    } else {
                        matrizconvertidos[i] = numero + 1;
                    }
                }  else {
                    matrizconvertidos[i] = numero;
                }
            } else {
                if (Calculator.esPar(numero)) {
                    if(numero + 1 > 99) {
                        matrizconvertidos[i] = numero - 1;
                    } else {
                        matrizconvertidos[i] = numero + 1;
                    }
                } else {
                    matrizconvertidos[i] = numero;
                }
            }
        }
        return matrizconvertidos;
    }
    
    /**
     * Elimina los duplicados de un array de enteros
     * @param array The array
     * @return Devuelve una matriz de enteros
     */
    public static int[] eliminarDuplicados (int[] array) {      
        int[] matrizsnoduplicados;               
        int numeros = 0;      
        for (int valor : array) {          
            int repeticiones = 0;          
            for (int numero : array) {              
                if (numero == valor) {                  
                    repeticiones++;
                }        
            }         
            if (repeticiones == 1) {         
                numeros++;
            }   
        }
        matrizsnoduplicados = new int[numeros];
        int contador = 0;
        for (int valor : array) {   
            int repeticiones = 0;
            for (int numero : array) {   
                if (numero == valor) {   
                    repeticiones++;
                }        
            }
            if (repeticiones == 1) {   
                matrizsnoduplicados[contador] = valor;      
                contador++; 
            } 
        }
        return matrizsnoduplicados;
    }
    
    /**
     * Suma los valores de una matriz
     * @param array The Array
     * @return int
     */
    public static int suma (int[] array) {  
       int suma = 0;
       for (int numero : array) { 
            suma += numero;
        }
        return suma;
    }
    
    /**
     * Transpone una matriz multiple 
     * @param array The array
     */
    public static void trasponerMultiple(int[][] array) {
        for (int fila = 1; fila < array.length; fila++) {
            for (int columna = 0; columna < fila; columna++) {
                int temp = array[fila][columna];
                array[fila][columna] = array[columna][fila];
                array[columna][fila] = temp;
            }
        }
    }
    
    /**
     * Comprueba si un array es simetrico
     * @param matriz The amtriz
     * @return boolean
     */
    public static boolean isSymmetric (int[][] matriz) {
        boolean symmetric = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return symmetric;
    }
    
    /**
     * Genera un array simetrico
     * @param num Tamaño array
     * @return int[][]
     */
    public static int[][] getSymmetric (int num) {
        int[][] matriz = new int[num][num];
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j <= i; j++) {
                matriz[i][j] = RandomMaker.between(0, 100);
                matriz[j][i] = matriz[i][j];
            }
        }    
        return matriz;
    }
    
    /**
     *  Cuenta el numero de filas de una matriz de dos dimensiones.
     * @param matriz
     * @return
     */
    public static int getColumnas (int[][] matriz) {
        int[] minimatriz = matriz[0];
        return minimatriz.length;
    }
    
    /**
     * Saca los numeros de un array de Strings
     * @param texto EL array de strings
     * @return int[] El array con los enteros
     */
    public static int[] getIntegers(String[] texto){
        int numeros = 0;
        for (String texto1 : texto) {
            try {
                int tmp = Integer.parseInt(texto1);
                numeros++;
            }catch (Exception e) {
                
            }  
        }
        int[] resultado = new int[numeros];
        int contador = 0;
        for (String texto1 : texto) {
            try {
                int tmp = Integer.parseInt(texto1);
                resultado[contador] = tmp;
                contador++;
            }catch (Exception e) {
                
            }  
        }
        return resultado;
    }
        
    /**
     * Clona un array de objetos en otro
     * @param objetos_a El array a clonar
     * @param objetos_b El array destino
     */
    public static void copyContent(Object[] objetos_a, Object[] objetos_b) {
        if (objetos_a.length < objetos_b.length) {
            System.arraycopy(objetos_a, 0, objetos_b, 0, objetos_a.length);   
        } else {
            System.arraycopy(objetos_a, 0, objetos_b, 0, objetos_b.length); 
        } 
    }
}

