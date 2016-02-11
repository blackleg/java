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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
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
    
    
    
    
}
