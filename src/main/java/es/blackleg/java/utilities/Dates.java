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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hector
 */
public class Dates {
    
    public static final long SECONDS_IN_MONTH = 2678400;
    public static final long SECONDS_IN_WEEK = 604800;
    
    public static Date fromStringWithFormat(String format, String stringFecha) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
        return formatoDelTexto.parse(stringFecha);
    }
    
    public static Integer differenceInMonths(Date beginningDate, Date endingDate) {
        if (beginningDate == null || endingDate == null) {
            return 0;
        }
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(beginningDate);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(endingDate);
        return differenceInMonths(cal1, cal2);
    }

    public static Integer differenceInMonths(Calendar beginningDate, Calendar endingDate) {
        if (beginningDate == null || endingDate == null) {
            return 0;
        }
        int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
        int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
        return m2 - m1;
    }
    
    public static Integer transformMonthsCountToYears(Integer months) {
        return months / 12;
    }
    
    /**
     * Transforma un Date en un String con el valor Long del Date.
     * @param fecha
     * @return 
     */
    public static String transformDateToLongString(Date fecha) {
        if (fecha == null) {
            return null;
	} else {
            return String.valueOf(fecha.getTime());
	}
    }
    
    
    public static String toStringWithFormat(String format, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    
    public static String toStringWithFormat(String format, Date date, TimeZone timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }
    
    /**
     * New Date
     * @return
     */
    public static Date now() {
        return new Date();
    }
    
    /**
     * Date from Long
     * @param longDate
     * @return
     */
    public static Date from(Long longDate) {
        if (Objects.isNull(longDate)) {
            return null;
        } else {
            return new Date(longDate);
        }
    }
    
    public static boolean checkTwoDatesIfNotNull(Date fromDate, Date untilDate) {
        return Objects.nonNull(fromDate) && Objects.nonNull(untilDate);
    }
    
    public static long getSecondsInDateInterval(Date fromDate, Date untilDate) {
        long fromTimeInterval = fromDate.getTime();
        long untilTimeInterval = untilDate.getTime();
        long secondsInTheInterval = untilTimeInterval - fromTimeInterval;
        return TimeUnit.MILLISECONDS.toSeconds(secondsInTheInterval);
    }
    
    public static long getDaysInTheInterval(long interval) {
        return TimeUnit.SECONDS.toDays(interval);
    }
    
    public static long getWeeksInTheInterval(long interval) {
        return interval/SECONDS_IN_WEEK;
    }
    
    public static long getMonthsInTheInterval(long interval) {
        return interval/SECONDS_IN_MONTH;
    }
    
    public static long secondsInMonths(long months) {
        return months*SECONDS_IN_MONTH;
    }
    
    public static long secondsInWeeks(long weeks) {
        return weeks*SECONDS_IN_WEEK;
    }
    
    public static long secondsInDays(long days) {
        return TimeUnit.DAYS.toSeconds(days);
    }
    
    public static long getMinutesInTheInterval(long interval) {
        return TimeUnit.SECONDS.toMinutes(interval);
    }
    
    public static long secondsFromMilis(long miliseconds) {
        return TimeUnit.MILLISECONDS.toSeconds(miliseconds);
    }
    
    public static String getMilisTimeString(Date date) {
        return Long.toString(date.getTime());
    }
    
    /**
     * Check if date interval collision another date interval
     * @param firstDateInInterval
     * @param secondDateInInterval
     * @param firsrDateInIntervalToCompare
     * @param secondDateInIntervalToCompare
     * @return
     */
    public static boolean checkIfDatesIntervalCollisionAnotherInterval(Date firstDateInInterval, Date secondDateInInterval, Date firsrDateInIntervalToCompare, Date secondDateInIntervalToCompare) {
        if (Objects.nonNull(firstDateInInterval) && Objects.nonNull(secondDateInInterval) && Objects.nonNull(firsrDateInIntervalToCompare) && Objects.nonNull(secondDateInIntervalToCompare)) {
            return beforeOrEquals(secondDateInIntervalToCompare, firstDateInInterval) && afterOrEquals(firsrDateInIntervalToCompare, secondDateInInterval);
        } else {
            return false;
        }
    }
    
    public static boolean afterOrEquals(Date dateToCompare, Date date) {
        if (checkTwoDatesIfNotNull(dateToCompare, date)) {
            return dateToCompare.getTime() <= date.getTime();
        } else {
            return false;
        }
    }
    
    public static boolean beforeOrEquals(Date dateToCompare, Date date) {
        if (checkTwoDatesIfNotNull(dateToCompare, date)) {
            return dateToCompare.getTime() >= date.getTime();
        } else {
            return false;
        }
    }
    
    /**
     * Check if Date Interval is inside another interval
     * @param firstDateInterval
     * @param secondDateInterval
     * @param firsrDateIntervalToCompare
     * @param secondDateIntervalToCompare
     * @return
     */
    public static boolean checkIfDatesIntervalIsInsideAnotherInterval(Date firstDateInterval, Date secondDateInterval, Date firsrDateIntervalToCompare, Date secondDateIntervalToCompare) {
        if (Objects.nonNull(firstDateInterval) && Objects.nonNull(secondDateInterval) && Objects.nonNull(firsrDateIntervalToCompare) && Objects.nonNull(secondDateIntervalToCompare)) {
            return checkIfDateIsBetweenDates(firstDateInterval, firsrDateIntervalToCompare, secondDateIntervalToCompare) && checkIfDateIsBetweenDates(secondDateInterval, firsrDateIntervalToCompare, secondDateIntervalToCompare);
        } else {
            return false;
        }
    }
    
    /**
     * Check if date interval contains another date interval
     * @param firstDate
     * @param secondDate
     * @param firsrDateInIntervalToCompare
     * @param secondDateInIntervalToCompare
     * @return
     */
    public static boolean checkIfDatesIntervalContainsAnotherInterval(Date firstDate, Date secondDate, Date firsrDateInIntervalToCompare, Date secondDateInIntervalToCompare) {
        if (Objects.nonNull(firstDate) && Objects.nonNull(secondDate) && Objects.nonNull(firsrDateInIntervalToCompare) && Objects.nonNull(secondDateInIntervalToCompare)) {
            return beforeOrEquals(firsrDateInIntervalToCompare, firstDate) && afterOrEquals(secondDateInIntervalToCompare, secondDate);
        } else {
            return false;
        }
    }
    
    /**
     * Check if Date is between two Dates
     * @param date
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static boolean checkIfDateIsBetweenDates(Date date, Date firstDate, Date secondDate) {
        if (Objects.nonNull(date) && Objects.nonNull(firstDate) && Objects.nonNull(secondDate)) {
            return afterOrEquals(firstDate, date) && beforeOrEquals(secondDate, date);
        } else {
            return false;
        }
    }
    
    /**
     * Calls {@link #toLocalDate(Date, ZoneId)} with the system default time zone.
     * @param date
     * @return 
     */
    public static LocalDate toLocalDate(java.util.Date date) {
        return toLocalDate(date, ZoneId.systemDefault());
    }
    
    /**
     * Creates {@link LocalDate} from {@code java.util.Date} or it's subclasses. Null-safe.
     * @param date
     * @param zone
     * @return 
     */
    public static LocalDate toLocalDate(java.util.Date date, ZoneId zone) {
        if (Objects.isNull(date)) {
            return null;
        }
        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate();
        } else {
            return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
        }   
    }

}
