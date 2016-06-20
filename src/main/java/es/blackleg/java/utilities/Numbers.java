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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author hector
 */
public class Numbers {
    
    public static final double ZERODOUBLE = 0.0; 
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int MINUSONE = -1;
    public static final int TWO = 2;
    public static final int MINUSTWO = -2;
    
    /**
     *
     * @param number
     * @return
     */
    public static boolean isInt(String number) {
        if (Strings.checkIfIsEmptyOrNull(number)) {
            return false;
        }
        int i = 0;
        if (number.charAt(0) == '-') {
            if (number.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c <= '/' || c >= ':') {
               return false;
            }
        }
        return true;
    }
    
    
    public static DecimalFormat getDecimalFormat() {
        return new DecimalFormat();
    }
    
    public static DecimalFormat getDecimalFormat(String format) {
        return new DecimalFormat(format);
    }
    
    
    
    /**
     * Simple round double to string
     * @param number A double number
     * @return Rounded double string
     */
    public static String simpleRoundDoubleToString(double number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(TWO);
        numberFormat.setMinimumFractionDigits(TWO);
        return numberFormat.format(number);
    }
    
    public static BigDecimal getBitDecimal(double number) {
        return new BigDecimal(number);
    }
    
    public static BigDecimal getBigDecimalWithScale(double number, int scale) {
        return getBitDecimal(number).setScale(scale, RoundingMode.HALF_UP);
    }
    
    /**
     * Simple round double
     * @param number A double number
     * @return Rounded double
     */
    public static double simpleRoundDouble(double number) {
        return getBigDecimalWithScale(number, TWO).doubleValue();
    }
    
    public static NumberFormat getCurrencyFormat() {
        return NumberFormat.getCurrencyInstance();
    }
    
    public static NumberFormat getCurrencyFormat(Locale locale) {
        return NumberFormat.getCurrencyInstance(locale);
    }
    
    /**
     * Transform double to currency locale
     * @param locale The currency locale
     * @param number The number to format
     * @return String
     */
    public static String getCurrencyString(Locale locale, double number) {
        return getCurrencyFormat(locale).format(number);
    }
    
    /**
     * Transform long to currency locale
     * @param locale The currency locale
     * @param number The number to format
     * @return String
     */
    public static String getCurrencyString(Locale locale, long number) {
        return getCurrencyFormat(locale).format(number);
    }
    
    /**
     * Convierte un double a un int
     * @param number
     * @return
     */
    public static int intFromDouble(double number){
        return Double.valueOf(number).intValue();
    }
    
    /**
     *
     * @param number
     * @return
     */
    public static Integer integerFromDouble(double number){
        return intFromDouble(number);
    }
    
    public static double doubleFromInt(int number) {
        return Integer.valueOf(number).doubleValue();
    }
    
    /**
     * Round to the next multiple
     * @param number
     * @param multiple
     * @return
     */
    public static int roundToMultiple(double number, int multiple){
        return Math.toIntExact(Math.round(number/multiple) * multiple);
    }
    
    /**
     * Round to the next multiple
     * @param number
     * @param multiple
     * @return
     */
    public static int roundToMultiple(int number, int multiple){
        return roundToMultiple(doubleFromInt(number), multiple);
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static boolean isNegative(double number) {
        return number < 0;
    }

    /**
     * Cuenta la parte entera de un double
     * @param numero El numero
     * @return int La parte entera
     */
    public static int contarEnteros(double numero) {
        int enteros = 0;
        String s_numero = String.valueOf(numero);
        char[] numeros = s_numero.toCharArray();
        for (char c : numeros) {
            if (c == ".".charAt(0)) {
                return enteros;
            } else {
                enteros++;
            }
        }
        return enteros;
    }

    /**
     * Si un entero es par devuelve true.
     * @param candidato El numero a comprobar
     * @return boolean
     */
    public static boolean isPar(int candidato) {
        return candidato % 2 == 0;
    }

    /**
     * Si un entero es impar devuelve true.
     * @param candidato El numero a comprobar
     * @return boolean
     */
    public static boolean isImpar(int candidato) {
        return candidato % 2 != 0;
    }
    
    /**
     * Return if number is higher than number to compare
     * @param numberToCompare
     * @param number
     * @return True if number is higher than number to compare
     */
    public static boolean isHigherThan(Double numberToCompare, Double number) {
        return number > numberToCompare;
    }
    
    
    
}
