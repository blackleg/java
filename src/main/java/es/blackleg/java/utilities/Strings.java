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
    
}
