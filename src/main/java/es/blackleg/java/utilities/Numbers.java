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

import java.text.DecimalFormat;

/**
 *
 * @author hector
 */
public class Numbers {
    
    private static final DecimalFormat DECIMALFORMAT = new DecimalFormat(".##");
    
    public static final double ZERODOUBLE = 0.0; 
    public static final int ZERO = 0;
    public static final int ONE = 1;
    
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
    
    public static double simpleRoundDouble(double number) {
        String doubleString = DECIMALFORMAT.format(number);
        return Double.parseDouble(doubleString);
    }
    
    /**
     * Convierte un double a un int
     * @param number
     * @return
     */
    public static int intFromDouble(double number){
        return Double.valueOf(number).intValue();
    }
    
    public static Integer integerFromDouble(double number){
        return intFromDouble(number);
    }
    
    
    
    
}
