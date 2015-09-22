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

import es.blackleg.java.exceptions.StringEmptyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Blackleg blackleg@openaliasbox.org
 */
public class Validator {
    
    //Patterns
    private static final String dni = "(\\d{8})([-]?)([A-Z]{1})";
    private static final String noString = "[a-zA-Z]*";
    private static final String onlyNumber = "[0-9]*";
    private static final String containsNumber = ".*\\d.*";
    
    /**
     * [ES] Comprueba un string con el patron
     * @param string The string
     * @param pattern The pattern
     * @return boolean
     * @throws es.blackleg.java.exceptions.StringEmptyException String is empty
     */
    public static boolean checkStringWithPattern(String string, String pattern) throws StringEmptyException {
        if (Strings.checkIfIsNotEmptyOrNull(string)) {
            Pattern pat = Pattern.compile(pattern);
            if (Strings.checkIfIsNotEmptyOrNull(string)) {
                Matcher mat = pat.matcher(string);
                return mat.matches();
            } else {
                throw new StringEmptyException();
            }
        } else {
            throw new StringEmptyException();
        }
    }


    public static boolean checkStringNoNumber(String string) throws StringEmptyException {
        return checkStringWithPattern(string, noString);
    }

    public static boolean checkStringOnlyNumber(String string) throws StringEmptyException {
        return checkStringWithPattern(string, onlyNumber);
    }

    public static boolean checkStringIsDni(String string) throws StringEmptyException {
        return checkStringWithPattern(string, dni);
    }
    
    public static boolean checkIfStringContainsNumber(String string) throws StringEmptyException {
        return checkStringWithPattern(string, containsNumber);
    }
    
}
