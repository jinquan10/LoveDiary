package org.jz.lovediary.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by JZ on 3/8/2016.
 */
public class UtilsTest {
    @Test
    public void testIsFromToday_whenNow_WillReturnTrue() {
        Assert.assertTrue(Utils.isFromToday(System.currentTimeMillis()));
    }

    @Test
    public void testIsFromToday_whenOneDayPrior_WillReturnFalse() {
        Assert.assertFalse(Utils.isFromToday(System.currentTimeMillis() - Utils.MILLIS_PER_DAY));
    }

    @Test
    public void testIsFromToday_whenOneDayAfter_WillReturnFalse() {
        Assert.assertFalse(Utils.isFromToday(System.currentTimeMillis() + Utils.MILLIS_PER_DAY));
    }
}
