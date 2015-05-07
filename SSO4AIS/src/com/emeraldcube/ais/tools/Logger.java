/*
 * The MIT License
 *
 * Copyright 2015 EmeraldCube Solutions, LLC.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.emeraldcube.ais.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author mtamassia Created on May 7, 2015 3:31:27 PM
 */
public class Logger {

    private static final boolean debugEnabled = false;

    /**
     * Prints to system out
     *
     * @param Message Text to print
     */
    public static void l(Object Message) {
        System.out.println(currentTimeStamp(0) + ": " + Message.toString());
    }

    /**
     * Print debug messages to system out
     *
     * @param Message Text to print
     */
    public static void d(Object Message) {
        if (debugEnabled) {
            System.out.println(currentTimeStamp(0) + ": " + Message.toString());
        }
    }

    /**
     * return current timeStamp String
     *
     * @param daysOffset int days to offset
     * @return Current TimeStamp in String based on days offset
     */
    private static String currentTimeStamp(int daysOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysOffset);
        Timestamp curtimestamp = new Timestamp(calendar.getTime().getTime());
        String S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(curtimestamp);
        return S;
    }
}
