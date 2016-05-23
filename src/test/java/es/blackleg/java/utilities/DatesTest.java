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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class DatesTest {
    
    public DatesTest() {
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
    
    @Test
    public void testGetDaysInTheInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long daysInterval = Dates.getDaysInTheInterval(secondsInterval);
        long daysResult = 2;
        assertEquals(daysResult, daysInterval);
        
    }
    
    @Test
    public void testGetSecondsInDateInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:10");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long secondsResult = 600;
        assertEquals(secondsResult, secondsInterval);
        
    }
    
    @Test
    public void testGetWeeksInTheInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate= dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeksInterval = Dates.getWeeksInTheInterval(secondsInterval);
        long weeksResult = 1;
        assertEquals(weeksResult, weeksInterval);
        
    }
    
    /**
     * Test of checkIfDatesIntervalIsInsideAnotherInterval method, of class DateUtils.
     */
    @Test
    public void testCheckIfDatesIntervalIsInsideAnotherInterval() throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDateInIntervalToCompare = dateFormat.parse("05-01-2016");
        Date secondDateInIntervalToCompare = dateFormat.parse("10-01-2016");
        
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(null, null, null, null));
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(null, null, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        Date firstDateInInterval = dateFormat.parse("01-01-2016");
        Date secondDateInInterval = dateFormat.parse("04-01-2016");
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("11-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("01-01-2016");
        secondDateInInterval = dateFormat.parse("06-01-2016");
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("08-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("04-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("06-01-2016");
        secondDateInInterval = dateFormat.parse("09-01-2016");
        assertTrue(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("05-01-2016");
        secondDateInInterval = dateFormat.parse("10-01-2016");
        assertTrue(Dates.checkIfDatesIntervalIsInsideAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
         
    }

    /**
     * Test of checkIfDateIsBetweenDates method, of class DateUtils.
     */
    @Test
    public void testCheckIfDateIsBetweenDates() throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDate = dateFormat.parse("05-01-2016");
        Date secondDate = dateFormat.parse("10-01-2016");
        
        assertFalse(Dates.checkIfDateIsBetweenDates(null, null, null));
        assertFalse(Dates.checkIfDateIsBetweenDates(null, firstDate, secondDate));

        Date date = dateFormat.parse("04-01-2016");
        assertFalse(Dates.checkIfDateIsBetweenDates(date, firstDate, secondDate));
        
        date = dateFormat.parse("11-01-2016");
        assertFalse(Dates.checkIfDateIsBetweenDates(date, firstDate, secondDate));
        
        date = dateFormat.parse("08-01-2016");
        assertTrue(Dates.checkIfDateIsBetweenDates(date, firstDate, secondDate));
        
        date = dateFormat.parse("05-01-2016");
        assertTrue(Dates.checkIfDateIsBetweenDates(date, firstDate, secondDate));
        
        date = dateFormat.parse("10-01-2016");
        assertTrue(Dates.checkIfDateIsBetweenDates(date, firstDate, secondDate));
    }
    
    @Test
    public void testCheckIfDatesIntervalCollisionBetweenAnotherInterval() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDateInIntervalToCompare = dateFormat.parse("05-01-2016");
        Date secondDateInIntervalToCompare = dateFormat.parse("10-01-2016");
        
        assertFalse(Dates.checkIfDatesIntervalCollisionAnotherInterval(null, null, null, null));
        assertFalse(Dates.checkIfDatesIntervalCollisionAnotherInterval(null, null, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        Date firstDateInInterval = dateFormat.parse("01-01-2016");
        Date secondDateInInterval = dateFormat.parse("04-01-2016");
        assertFalse(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("11-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("01-01-2016");
        secondDateInInterval = dateFormat.parse("05-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("10-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("01-01-2016");
        secondDateInInterval = dateFormat.parse("08-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("08-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("06-01-2016");
        secondDateInInterval = dateFormat.parse("09-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("05-01-2016");
        secondDateInInterval = dateFormat.parse("10-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("01-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertTrue(Dates.checkIfDatesIntervalCollisionAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
    }
 
    
    
    @Test
    public void testCheckIfDatesIntervalContainsAnotherInterval() throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDateInIntervalToCompare = dateFormat.parse("05-01-2016");
        Date secondDateInIntervalToCompare = dateFormat.parse("10-01-2016");
        
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(null, null, null, null));
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(null, null, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        Date firstDateInInterval = dateFormat.parse("01-01-2016");
        Date secondDateInInterval = dateFormat.parse("04-01-2016");
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("11-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("01-01-2016");
        secondDateInInterval = dateFormat.parse("08-01-2016");
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("09-01-2016");
        secondDateInInterval = dateFormat.parse("14-01-2016");
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("06-01-2016");
        secondDateInInterval = dateFormat.parse("09-01-2016");
        assertFalse(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("04-01-2016");
        secondDateInInterval = dateFormat.parse("11-01-2016");
        assertTrue(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
        
        firstDateInInterval = dateFormat.parse("05-01-2016");
        secondDateInInterval = dateFormat.parse("10-01-2016");
        assertTrue(Dates.checkIfDatesIntervalContainsAnotherInterval(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
    }
    
    @Test
    public void testGetCalendarWithDate() {
        Date date = Dates.now();
        Calendar calendar = Dates.getCalendar(date);
        assertNotNull(calendar);
        assertEquals(date.getTime(), calendar.getTime().getTime());
    }
    
    @Test
    public void testAddSeconds() {
        Date date = Dates.now();
        int seconds = 60;
        Date addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
    }

    
    
}
