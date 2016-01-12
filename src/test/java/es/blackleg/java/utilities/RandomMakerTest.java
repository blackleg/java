/*
 * Copyright 2016 hector.
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class RandomMakerTest {
    
    public RandomMakerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of between method, of class RandomMaker.
     */
    @Test
    public void testBetween_int_int() {
        int min = 0;
        int max = 1;
        int result = RandomMaker.between(min, max);
        System.out.println(result);
        assertTrue(result >= min && result <= max);
    }

    /**
     * Test of between method, of class RandomMaker.
     */
    @Test
    public void testBetween_double_double() {
        double min = 0.0;
        double max = 1.0;
        double result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
    }

}
