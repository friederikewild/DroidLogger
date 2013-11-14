/*
 * Copyright (C) 2013 Friederike Wild <friederike.wild@devmob.de>
 * Created 27.10.2013
 * 
 * https://github.com/friederikewild/DroidLogger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.devmob.android.logger;

import android.util.Log;

/**
 * Simple wrapper around the android logging class Logger.
 * Adjust log level according to the purpose of the binary
 * and remove for release with e.g. 
 * -assumenosideeffects class de.devmob.androlib.logger.Logger {
    public static int v(...);
    [...]
    }
 * 
 * To avoid calls like 
 * Logger.v(TAG, "index=" + i);
 * that are internally creating new StringBuilder objects
 * methods per log level are provided to pass a string message and an object.
 * Only when the log level matches the string representations are then appended.
 * 
 * In case more then two objects should be logged, protect logging code with e.g.
 * if (Logger.shouldLog(Log.DEBUG))
 * 
 * @author Friederike Wild
 */
public class Logger
{
    /** Set to minimal log level to really log.
     * Includes all higher priorities:
     * DEBUG, INFO, WARN, ERROR */
    public static int MIN_ACTIVATED_LOG_LEVEL = Log.DEBUG;

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void v(String tag, String msg)
    {
        if (shouldLog(Log.VERBOSE))
        {
            Log.v(tag, msg);
        }
    }

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The object you would like logged.
     */
    public static void v(String tag, Object object)
    {
        if (shouldLog(Log.VERBOSE))
        {
            Log.v(tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The object you would like logged.
     */
    public static void v(String tag, String msg, Object object)
    {
        if (shouldLog(Log.VERBOSE))
        {
            Log.v(tag, msg + ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void v(String tag, String msg, Throwable tr)
    {
        if (shouldLog(Log.VERBOSE))
        {
            Log.v(tag, msg, tr);
        }
    }

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The object you would like logged.
     * @param tr An exception to log
     */
    public static void v(String tag, String msg, Object object, Throwable tr)
    {
        if (shouldLog(Log.VERBOSE))
        {
            Log.v(tag, msg + ToStringFormatter.getString(object), tr);
        }
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void d(String tag, String msg)
    {
        if (shouldLog(Log.DEBUG))
        {
            Log.d(tag, msg);
        }
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The object you would like logged.
     */
    public static void d(String tag, Object object)
    {
        if (shouldLog(Log.DEBUG))
        {
            d(tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The object you would like logged.
     */
    public static void d(String tag, String msg, Object object)
    {
        if (shouldLog(Log.DEBUG))
        {
            d(tag, msg + ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void d(String tag, String msg, Throwable tr)
    {
        if (shouldLog(Log.DEBUG))
        {
            Log.d(tag, msg, tr);
        }
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The object you would like logged.
     * @param tr An exception to log
     */
    public static void d(String tag, String msg, Object object, Throwable tr)
    {
        if (shouldLog(Log.DEBUG))
        {
            d(tag, msg + ToStringFormatter.getString(object), tr);
        }
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void i(String tag, String msg)
    {
        if (shouldLog(Log.INFO))
        {
            Log.i(tag, msg);
        }
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The message you would like logged.
     */
    public static void i(String tag, Object object)
    {
        if (shouldLog(Log.INFO))
        {
            i(tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     */
    public static void i(String tag, String msg, Object object)
    {
        if (shouldLog(Log.INFO))
        {
            i(tag, msg + ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void i(String tag, String msg, Throwable tr)
    {
        if (shouldLog(Log.INFO))
        {
            Log.i(tag, msg, tr);
        }
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     * @param tr An exception to log
     */
    public static void i(String tag, String msg, Object object, Throwable tr)
    {
        if (shouldLog(Log.INFO))
        {
            i(tag, msg + ToStringFormatter.getString(object), tr);
        }
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void w(String tag, String msg)
    {
        if (shouldLog(Log.WARN))
        {
            Log.w(tag, msg);
        }
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The message you would like logged.
     */
    public static void w(String tag, Object object)
    {
        if (shouldLog(Log.WARN))
        {
            w(tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     */
    public static void w(String tag, String msg, Object object)
    {
        if (shouldLog(Log.WARN))
        {
            w(tag, msg + ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void w(String tag, String msg, Throwable tr)
    {
        if (shouldLog(Log.WARN))
        {
            Log.w(tag, msg, tr);
        }
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     * @param tr An exception to log
     */
    public static void w(String tag, String msg, Object object, Throwable tr)
    {
        if (shouldLog(Log.WARN))
        {
            w(tag, msg + ToStringFormatter.getString(object), tr);
        }
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static void w(String tag, Throwable tr)
    {
        if (shouldLog(Log.WARN))
        {
            Log.w(tag, tr);
        }
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg)
    {
        if (shouldLog(Log.ERROR))
        {
            Log.e(tag, msg);
        }
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The message you would like logged.
     */
    public static void e(String tag, Object object)
    {
        if (shouldLog(Log.ERROR))
        {
            e(tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     */
    public static void e(String tag, String msg, Object object)
    {
        if (shouldLog(Log.ERROR))
        {
            e(tag, msg + ToStringFormatter.getString(object));
        }
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void e(String tag, String msg, Throwable tr)
    {
        if (shouldLog(Log.ERROR))
        {
            Log.e(tag, msg, tr);
        }
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param object The message you would like logged.
     * @param tr An exception to log
     */
    public static void e(String tag, String msg, Object object, Throwable tr)
    {
        if (shouldLog(Log.ERROR))
        {
            e(tag, msg + ToStringFormatter.getString(object), tr);
        }
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static void e(String tag, Throwable tr)
    {
        if (shouldLog(Log.ERROR))
        {
            Log.e(tag, "", tr);
        }
    }

    /**
     * Low-level logging call.
     * @param priority The priority/type of this log message
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void println(int priority, String tag, String msg)
    {
        if (shouldLog(priority))
        {
            Log.println(priority, tag, msg);
        }
    }

    /**
     * Low-level logging call.
     * @param priority The priority/type of this log message
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param object The message you would like logged.
     */
    public static void println(int priority, String tag, Object object)
    {
        if (shouldLog(priority))
        {
            Log.println(priority, tag, ToStringFormatter.getString(object));
        }
    }

    /**
     * Flag if logging for this log level is activated.
     * Use for pre logging calls when more then two objects need to be logged.
     * 
     * @param logLevel
     * @return
     */
    public static boolean shouldLog(int logLevel)
    {
        return (logLevel >= MIN_ACTIVATED_LOG_LEVEL);
    }
}
