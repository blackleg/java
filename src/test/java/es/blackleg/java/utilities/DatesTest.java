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
        Date fromDate = Dates.now();
        long secondsResult = 600;
        Date untilDate = Dates.addSeconds(fromDate, 600);
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 1);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 1;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 15);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 15;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 60);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 60;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 3600);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 3600;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 86400);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 86400;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, Long.valueOf(Dates.SECONDS_IN_WEEK).intValue());
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = Dates.SECONDS_IN_WEEK;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, Long.valueOf(Dates.SECONDS_IN_MONTH).intValue());
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = Dates.SECONDS_IN_MONTH;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 2678400);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 2678400;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 2505600);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 2505600;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 2678400);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 2678400;
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 9328200);
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        secondsResult = 9328200;
        assertEquals(secondsResult, secondsInterval);
    }

    @Test
    public void testGetMinutesFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:01");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long minutes = Dates.getMinutesFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 00:10");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 10;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 02:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes = Dates.getMinutesFromSeconds(secondsInterval);
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
        Date untilDate = dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        long weeksResult = 1;
        assertEquals(weeksResult, weeksInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("16-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 2;
        assertEquals(weeksResult, weeksInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("04-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 0;
        assertEquals(weeksResult, weeksInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("07-01-2016 23:59");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 0;
        assertEquals(weeksResult, weeksInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("30-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeksInterval = Dates.getWeeksFromSeconds(secondsInterval);
        weeksResult = 4;
        assertEquals(weeksResult, weeksInterval);
    }

    @Test
    public void testGetMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 0;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 1;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-04-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 3;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-08-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 7;
        assertEquals(expected, months);
    }

    @Test
    public void testRemoveMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("31-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, months);
        long removedSeconds = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:01");
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
        Date untilDate = dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeks = Dates.getWeeksFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, weeks);
        long removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("15-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeks = Dates.getWeeksFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, weeks);
        removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }

    @Test
    public void testRemoveDaysFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("02-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long days = Dates.getDaysFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, days);
        long removedSeconds = Dates.removeDaysFromSeconds(secondsInterval, days);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        days = Dates.getDaysFromSeconds(secondsInterval);
        expected = 4;
        assertEquals(expected, days);
        removedSeconds = Dates.removeDaysFromSeconds(secondsInterval, days);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }

    @Test
    public void testRemoveFromSeconds() throws ParseException {
        Date fromDate = Dates.now();
        Date untilDate = Dates.addSeconds(fromDate, 9328200);
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 3;
        assertEquals(expected, months);
        secondsInterval = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 1552200;
        assertEquals(expected, secondsInterval);

        long weeks = Dates.getWeeksFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, weeks);
        secondsInterval = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 342600;
        assertEquals(expected, secondsInterval);

        long days = Dates.getDaysFromSeconds(secondsInterval);
        expected = 3;
        assertEquals(expected, days);
        secondsInterval = Dates.removeDaysFromSeconds(secondsInterval, days);
        expected = 83400;
        assertEquals(expected, secondsInterval);

        long minutes = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 1390;
        assertEquals(expected, minutes);
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
     * Test of checkIfDatesIntervalIsInsideAnotherInterval method, of class
     * DateUtils.
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
     *
     * @throws java.text.ParseException
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
    public void testAddSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date date = dateFormat.parse("00:00");
        Date expectedDate = dateFormat.parse("01:00");
        int seconds = 60;
        Date addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);
        
        seconds = 0;
        addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
        
    }
    
    @Test
    public void testAddSecondsLong() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date date = dateFormat.parse("00:00");
        
        Date expectedDate = dateFormat.parse("01:00");

        long seconds = 60;
        Date addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);
        
        seconds = 0;
        addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

    @Test
    public void testConvertToSqlDate() {
        Date date = Dates.now();
        java.sql.Date sqlDate = Dates.convertToSqlDate(date);
        assertNotNull(sqlDate);
        assertEquals(date.getTime(), sqlDate.getTime());
    }

    @Test
    public void testBeforeOrEquals() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        
        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00"); 
        assertFalse(Dates.beforeOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertTrue(Dates.beforeOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertTrue(Dates.beforeOrEquals(untilDate, fromDate));
    }
    
    @Test
    public void testAfterOrEquals() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        
        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00"); 
        assertTrue(Dates.afterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertFalse(Dates.afterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDate, fromDate));
    }
    
    
    @Test
    public void testGetHoursFromSeconds() {
        
        long seconds = 3600;
        long expected = 1;
        long result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);
        
        seconds = 7200;
        expected = 2;
        result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);
        
        seconds = 18000;
        expected = 5;
        result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetMonthsFromDays() {
        long days = 30;
        long expected = 1;
        long result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);
        
        days = 60;
        expected = 2;
        result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);
        
        days = 35;
        expected = 1;
        result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);
    }
    
    
    @Test
    public void testGetDaysFromMonths() {
        long months = 1;
        long expected = 30;
        long result = Dates.getDaysFromMonths(months);
        assertEquals(expected, result);
        
        months = 2;
        expected = 60;
        result = Dates.getDaysFromMonths(months);
        assertEquals(expected, result);
    }
    
    
    @Test
    public void testRemoveMonthsFromDays() {
        
        long months = 1;
        long days = 31;
        long expected = 1;
        long result = Dates.removeMonthsFromDays(days, months);
        assertEquals(expected, result);
        
        months = 2;
        days = 62;
        expected = 2;
        result = Dates.removeMonthsFromDays(days, months);
        assertEquals(expected, result);
        

    }
    
    
    @Test
    public void testRoundToMinutes() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = dateFormat.parse("00:00:35");
        Date expectedDate = dateFormat.parse("00:01:00");
        Date resultDate = Dates.roundToMinutes(date);
        assertEquals(expectedDate, resultDate);
        
        date = dateFormat.parse("00:00:25");
        expectedDate = dateFormat.parse("00:00:00");
        resultDate = Dates.roundToMinutes(date);
        assertEquals(expectedDate, resultDate);
    }
    
    
    @Test
    public void testGetSecondsFromHours() {
        
        long hours = 1;
        long expected = 3600;
        long result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);
        
        hours = 2;
        expected = 7200;
        result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);
        
        hours = 5;
        expected = 18000;
        result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);
    }
    
    @Test
    public void testRoundToHour() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = dateFormat.parse("00:35:00");
        Date expectedDate = dateFormat.parse("01:00:00");
        Date resultDate = Dates.roundToHour(date);
        assertEquals(expectedDate, resultDate);
        
        date = dateFormat.parse("00:25:00");
        expectedDate = dateFormat.parse("00:00:00");
        resultDate = Dates.roundToHour(date);
        assertEquals(expectedDate, resultDate);
    }
    
    @Test
    public void testFloorToHour() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = dateFormat.parse("00:35:00");
        Date expectedDate = dateFormat.parse("00:00:00");
        Date resultDate = Dates.floorToHour(date);
        assertEquals(expectedDate, resultDate);
        
        date = dateFormat.parse("00:25:00");
        expectedDate = dateFormat.parse("00:00:00");
        resultDate = Dates.floorToHour(date);
        assertEquals(expectedDate, resultDate);
    }
    
    
    @Test
    public void testGetHoursInDateInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date fromDate = dateFormat.parse("00:00:00");
        Date untilDate = dateFormat.parse("01:00:00");
        long result = Dates.getHoursInDateInterval(fromDate, untilDate);
        assertEquals(1l, result);
        
        fromDate = dateFormat.parse("00:00:00");
        untilDate = dateFormat.parse("15:00:00");
        result = Dates.getHoursInDateInterval(fromDate, untilDate);
        assertEquals(15l, result);
    }
    
    @Test
    public void testAddDays() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = dateFormat.parse("05-01-2016 00:00");
        Date expectedDate = dateFormat.parse("06-01-2016 00:00");
        int days = 1;
        Date addedDate = Dates.addDays(date, days);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);
        
        days = 0;
        addedDate = Dates.addSeconds(date, days);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }
    
    @Test
    public void testRemoveDays() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = dateFormat.parse("06-01-2016 00:00");
        Date expectedDate = dateFormat.parse("05-01-2016 00:00");
        int days = 1;
        Date addedDate = Dates.removeDays(date, days);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);
        
        days = 0;
        addedDate = Dates.addSeconds(date, days);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

}
