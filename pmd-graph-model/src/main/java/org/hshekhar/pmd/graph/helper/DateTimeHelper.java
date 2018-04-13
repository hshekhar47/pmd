package org.hshekhar.pmd.graph.helper;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class DateTimeHelper
{
    public static final String dateToString(Date date)
    {
        DateTimeFormatter formatter = ISODateTimeFormat.date();
        return formatter.print(date.getTime());
    }

    public static final Date getMaxDate()
    {
        return new DateTime()
                .withDate(2999, 12, 31)
                .withTime(23, 59, 59, 999)
                .toDate();
    }
}
