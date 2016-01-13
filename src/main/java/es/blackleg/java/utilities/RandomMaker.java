/*
 * Copyright 2015 Blackleg.
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

import java.util.Random;

/**
 *
 * @author Blackleg
 */
public class RandomMaker {
    
    /**
     * It generates a random number between two numbers.
     * Genera un numero aleatorio entre dos numeros.
     * @param min
     * @param max
     * @return int
     */
    public static int between(int min, int max) {
        if (min > max) { 
            int aux = min;
            min = max;      
            max = aux;        
        }
        Random aleatorio = new Random();    
        int numale;
        do { 
            numale = aleatorio.nextInt(max + 1);
            if (aleatorio.nextBoolean()) { 
                numale = -numale; 
            }
        } while (numale < min);
        return numale;
    }
    
    /**
     * It generates a random number between two numbers.
     * Genera un numero aleatorio entre dos numeros.
     * @param min
     * @param max
     * @return double
     */
    public static double between(double min, double max) {   
        if (min > max) { 
            double aux = min;
            min = max;      
            max = aux;        
        }
        Random aleatorio = new Random();    
        double numale; 
        System.out.println(min);
        System.out.println(max);
        do {
            numale = aleatorio.nextDouble() * (max - min) + min;
            System.out.println("Numale");
            System.out.println(numale);
            if (aleatorio.nextBoolean()) { 
                numale = -numale;
            }  
        } while (numale <= min || numale >= max);
        return numale;
    }
    
    /**
     * Returns a array of random integers.
     * Devuelve una matrix de enteros aleatorios.
     * num es el tamaño de la matriz
     * @param num
     * @return int[]
     */
    public static int[] toArray(int num) { 
        int[] numeros = new int[num];
        Random aleatorio = new Random();
        for (int i = 0; i < numeros.length; i++) {
            int numero = aleatorio.nextInt();  
            numeros[i] = numero;

        }
        return numeros;
    }
    
    
    /**
     * Returns a array of random integers.
     * Devuelve una matrix de enteros aleatorios de 0 a un valor.
     * num es el tamaño de la matriz
     * max es el valor maximo de los aleatorios.
     * @param num
     * @param max
     * @return int[]
     */
    public static int[] toArray(int num, int max) {
        
        int[] numeros = new int[num];
        Random aleatorio = new Random();
        
        for (int i = 0; i < numeros.length; i++) {

            int numero = aleatorio.nextInt(max);            
            numeros[i] = numero;
            
        }

        return numeros;
    }
    
    /**
     * Devuelve una matrix de enteros aleatorios entre dos valores.
     * @param num
     * @param min
     * @param max
     * @return int[]
     */
    public static int[] toMatrizEntre (int num, int min, int max) {
        
        int[] numeros = new int[num];
        
        //Ordenar
        if (min > max) { 
            int aux = min;
            min = max;      
            max = aux;        
        }
        
        for (int i = 0; i < numeros.length; i++) {
            
            numeros[i] = between(min, max);
    
        }    
 
        return numeros;
    }
    
    /**
     * Devuelve una matriz multiplie con numeros aleatorios.
     * @param num
     * @return int[]
     */
    public static int[][] toMatrizMulti(int num) {
        
        int[][] numeros = new int[num][num];
        Random aleatorio = new Random();
        
        for (int[] matriz : numeros) {
            
            for (int i = 0; i < matriz.length; i++) {
             
                matriz[i] = aleatorio.nextInt();
                
                
            }        
        }
        return numeros;
    }
   
    
    /**
     * Devuelve una matriz 
     * @param num
     * @param max
     * @return int[][]
     */
    public static int[][] toMatrizMulti(int num, int max) {
        
        int[][] numeros = new int[num][num];
        Random aleatorio = new Random();
        
        for (int[] matriz : numeros) {
            for (int i = 0; i < matriz.length; i++) {
                matriz[i] = aleatorio.nextInt(max);  
            }        
        }
        return numeros;
    }
    
    /**
     *
     * @param num
     * @param min
     * @param max
     * @return int[][]
     */
    public static int[][] toMatrizMultiEntre (int num, int min, int max) {
        
        int[][] numeros = new int[num][num];
        
        //Ordenar
        if (min > max) { 
            int aux = min;
            min = max;      
            max = aux;        
        }
        
        
        for (int[] matriz : numeros) {
            for (int i = 0; i < matriz.length; i++) {
                matriz[i] = between(min, max);   
            }           
        }
        return numeros;
    }
    
    /**
     * Devuelve un boolean aleatorio.
     * @return boolean
     */
    public static boolean getBoolean() {
        Random aleatorio = new Random();
        return aleatorio.nextBoolean();  
    }
    
    /**
     * Devuelve un int aleatorio. 
     * @return boolean
     */
    public static int getInt() {
        Random aleatorio = new Random();
        return aleatorio.nextInt();
    }
    
}
