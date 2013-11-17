/*
 * Copyright (C) 2013 Friederike Wild <friederike.wild@devmob.de> Created 14.11.2013
 * 
 * https://github.com/friederikewild/DroidLogger
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.devmob.android.logger.demo.data;

import de.devmob.android.logger.ToStringFormatter;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

public class CursorExample extends ObjectExample<Cursor>
{
    private final Cursor cursor;

    public CursorExample(Context context, int maxDisplayNumber)
    {
        final String[] PEOPLE_PROJECTION = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
        };

        ContentResolver content = context.getContentResolver();
        Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;
        cursor = content.query(contactsUri, PEOPLE_PROJECTION, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC LIMIT " + maxDisplayNumber);

        initWithTitleFromCreatedObject(getTitle(maxDisplayNumber));
    }

    @Override
    public Cursor getCreatedObject()
    {
        return cursor;
    }

    @Override
    public void close()
    {
        if (cursor != null)
        {
            cursor.close();
        }
    }

    private String getTitle(int maxDisplayNumber)
    {
        if (maxDisplayNumber == 0)
        {
            return "Cursor (empty):";
        }
        else
        {
            return "Cursor (" + maxDisplayNumber+ " contacts alphabetically ordered):";
        }
    }
}
