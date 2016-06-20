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
    public void testGetSecondsFromMillis() {
        long millis = 1000;
        long seconds = Dates.getSecondsFromMillis(millis);
        long expected = 1;
        assertEquals(expected, seconds);
        millis = 60000;
        seconds = Dates.getSecondsFromMillis(millis);
        expected = 60;
        assertEquals(expected, seconds);
    }
    
    @Test
    public void testGetSecondsInDateInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:10");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long secondsResult = 600;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 60;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 01:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 3600;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("02-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 86400;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("08-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = Dates.SECONDS_IN_WEEK;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = Dates.SECONDS_IN_MONTH;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-02-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 2678400;
        assertEquals(secondsResult, secondsInterval);
        
        fromDate = dateFormat.parse("01-02-2016 00:00");
        untilDate = dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 2505600;
        assertEquals(secondsResult, secondsInterval);
        
    }
    
    @Test
    public void testGetMinutesFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:01");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long minutes  = Dates.getMinutesFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 00:10");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes  = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 10;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 02:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes  = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 120;
        assertEquals(expected, minutes);
    }
    
    @Test
    public void testGetDaysFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        long daysResult = 2;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 30;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-02-2015 00:00");
        untilDate = dateFormat.parse("01-03-2015 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 28;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-02-2016 00:00");
        untilDate = dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 29;
        assertEquals(daysResult, daysInterval);
    }
    
    @Test
    public void testGetWeeksInTheInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate= dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        long weeksResult = 1;
        assertEquals(weeksResult, weeksInterval);       
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("16-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 2;
        assertEquals(weeksResult, weeksInterval);      
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("04-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 0;
        assertEquals(weeksResult, weeksInterval);      
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("07-01-2016 23:59");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 0;
        assertEquals(weeksResult, weeksInterval);     
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("30-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 4;
        assertEquals(weeksResult, weeksInterval);
    }
    
    @Test
    public void testGetMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate= dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 0;
        assertEquals(expected, months); 
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 1;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("01-04-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 3;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("01-08-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 7;
        assertEquals(expected, months);
    }
    
    @Test
    public void testRemoveMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate= dateFormat.parse("31-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, months);
        long removedSeconds = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 0;
        assertEquals(expected, removedSeconds);     
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("31-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 1;
        assertEquals(expected, months);
        removedSeconds = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }
    
    @Test
    public void testRemoveWeeksFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate= dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeks = Dates.getWeeksFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, weeks);
        long removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 0;
        assertEquals(expected, removedSeconds);     
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate= dateFormat.parse("15-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeks = Dates.getWeeksFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, weeks);
        removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }
    
    @Test
    public void testGetSecondsFromDays() {
        long days = 1;
        long seconds = Dates.getSecondsFromDays(days);
        long expected = Dates.SECONDS_IN_DAY;
        assertEquals(expected, seconds);
        days = 14;
        seconds = Dates.getSecondsFromDays(days);
        expected = 1209600;
        assertEquals(expected, seconds);
        days = 30;
        seconds = Dates.getSecondsFromDays(days);
        expected = 2592000;
        assertEquals(expected, seconds);
    }
    
    @Test
    public void testGetSecondsFromWeeks() {
        long weeks = 1;
        long seconds = Dates.getSecondsFromWeeks(weeks);
        long expected = Dates.SECONDS_IN_WEEK;
        assertEquals(expected, seconds);
        weeks = 2;
        seconds = Dates.getSecondsFromWeeks(weeks);
        expected = 1209600;
        assertEquals(expected, seconds);
        weeks = 3;
        seconds = Dates.getSecondsFromWeeks(weeks);
        expected = 1814400;
        assertEquals(expected, seconds);
    }
    
    @Test
    public void testGetSecondsFromMonths() {
        long months = 1;
        long seconds = Dates.getSecondsFromMonths(months);
        long expected = Dates.SECONDS_IN_MONTH;
        assertEquals(expected, seconds);
        months = 2;
        seconds = Dates.getSecondsFromMonths(months);
        expected = 5184000;
        assertEquals(expected, seconds);
        months = 3;
        seconds = Dates.getSecondsFromMonths(months);
        expected = 7776000;
        assertEquals(expected, seconds);
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
