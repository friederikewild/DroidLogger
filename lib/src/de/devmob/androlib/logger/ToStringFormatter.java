/*
 * Copyright 2013 Friederike Wild, created 26.10.2013
 */
package de.devmob.androlib.logger;

import java.util.Collection;
import java.util.Map;

import android.database.Cursor;

/**
 * Formatter to create readable strings from common used objects that
 * lack their own useful toString method. Useful to log collections like lists or maps,
 * native arrays or Android Cursors.
 * 
 * Call ToStringFormatter.getString() with any kind of object and let it handle the type check.
 * Get a readable string containing the available content instead of the default output that often only
 * contains the class name and the object id.
 * 
 * @author Friederike Wild
 */
public class ToStringFormatter
{
    public static String getString(Collection<?> set)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Collection: (");
        int entryCount = 0;
        for (Object entry : set)
        {
            sb.append(getString(entry));
            entryCount++;
            addEntrySeparatorIfNeeded(entryCount, set.size(), sb);
        }
        sb.append(")");
        return sb.toString();
    }

    public static String getString(Map<?, ?> map)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Map: {");
        int entryCount = 0;
        for (Object key : map.keySet())
        {
            sb.append(getString(key) + "=>" + getString(map.get(key)));
            entryCount++;
            addEntrySeparatorIfNeeded(entryCount, map.size(), sb);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String getString(Cursor c)
    {
        StringBuilder sb = new StringBuilder();

        if (c.getCount() == 0)
        {
            sb.append("Empty cursor");
        }
        else
        {
            sb.append("Cursor: ");
            // store current position
            int currentPos = c.getPosition();
            c.moveToFirst();

            String[] colNames = c.getColumnNames();
            do
            {
                int colCount = 0;
                for (String colName : colNames)
                {
                    int rowId = c.getColumnIndex(colName);
                    if (rowId != -1)
                    {
                        // With sqlite all column types are stored as string and can be requested as such
                        sb.append(colName + "=>" + c.getString(rowId));
                    }
                    colCount++;
                    addEntrySeparatorIfNeeded(colCount, colNames.length, sb);
                }

                if (!c.isLast())
                {
                    sb.append("; ");
                }

            }
            while (c.moveToNext());

            // reset position:
            c.moveToPosition(currentPos);
        }
        return sb.toString();
    }

    public static String getString(Throwable t)
    {
        return android.util.Log.getStackTraceString(t);
    }

    /**
     * Overloaded method for all otherwise unmapped methods.
     * Handles null value as well!
     * 
     * @param var
     * @return
     */
    public static String getString(Object var)
    {
        if (var == null)
        {
            return "NULL";
        }

        // Java arrays always start with a open bracket followed by the type.
        if (var.getClass().toString().startsWith("class ["))
        {
            StringBuilder sb = new StringBuilder();
            try
            {
                dumpArrayToStringBuilder(var, sb);
            }
            catch (Throwable t)
            {
                // Reset any half written output
                sb.delete(0, sb.length());
                sb.append("Problem logging class with type " + var.getClass().toString());
            }

            return sb.toString();
        }

        // Else: for all other classes call through to native toString method 
        return var.toString();
    }

    private static void dumpArrayToStringBuilder(Object var, StringBuilder sb)
    {
        sb.append("[");

        // Special check for boolean array
        if (var.getClass().toString().startsWith("class [Z"))
        {
            boolean[] convertedArray = (boolean[]) var;
            dumpBoolArrayToStringBuilder(convertedArray, sb);
        }
        else
        {
            // Assume the type is supporting toString
            Object[] convertedArray = (Object[]) var;
            dumpObjectArrayToStringBuilder(convertedArray, sb);
        }

        sb.append("]");
    }

    private static void dumpBoolArrayToStringBuilder(boolean[] convertedArray, StringBuilder sb)
    {
        for (int i = 0; i < convertedArray.length; i++)
        {
            sb.append(convertedArray[i] ? "true" : "false");
            addEntrySeparatorIfNeeded(i, convertedArray.length - 1, sb);
        }
    }

    private static void dumpObjectArrayToStringBuilder(Object[] convertedArray, StringBuilder sb)
    {
        for (int i = 0; i < convertedArray.length; i++)
        {
            sb.append(getString(convertedArray[i]));
            addEntrySeparatorIfNeeded(i, convertedArray.length - 1, sb);
        }
    }

    private static void addEntrySeparatorIfNeeded(int entryCount, int maxSize, StringBuilder sb)
    {
        if (entryCount < maxSize)
        {
            sb.append(", ");
        }
    }
}
