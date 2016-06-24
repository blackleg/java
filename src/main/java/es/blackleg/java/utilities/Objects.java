/*
 * Copyright 2016 Blackleg.
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
 * @author hector
 */
public class Objects {
    
    public static boolean nonNull(Object object) {
        return !isNull(object);
    }
    
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean nonNull(Object objectOne, Object objectTwo) {
        return nonNull(objectOne) && nonNull(objectTwo);
    }
    
}
