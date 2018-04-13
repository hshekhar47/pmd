package org.hshekhar.pmd.graph.helper;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTimeHelperTest
{
    @Test
    public void dateToUTCString() throws Exception
    {
        Date date = DateTimeHelper.getMaxDate();
        assertEquals("Date should be 2999-12-31",
                     "2999-12-31",
                     DateTimeHelper.dateToString(date));
    }

    @Test
    public void getMaxDate() throws Exception
    {
        DateTime dateTime = new DateTime(DateTimeHelper.getMaxDate());
        assertEquals("Year should be 2999", 2999, dateTime.getYear());
        assertEquals("Month should be 12", 12, dateTime.getMonthOfYear());
        assertEquals("Day should be 31 ", 31, dateTime.getDayOfMonth());
    }

}