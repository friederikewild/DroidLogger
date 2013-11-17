/*
 * Copyright (C) 2013 Friederike Wild <friederike.wild@devmob.de> Created 15.11.2013
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

import de.devmob.android.logger.Logger;
import de.devmob.android.logger.ToStringFormatter;

public abstract class ObjectExample<T> extends Example
{
    void initWithTitleFromCreatedObject(String title)
    {
        this.title = title;
        try
        {
            this.standard = getCreatedObject().toString();
        }
        catch (Exception e)
        {
            this.standard = "<throws " + e.getClass().getSimpleName() + ">";
        }
        this.example = ToStringFormatter.getString(getCreatedObject());
    }

    @Override
    public void log(final String tag)
    {
        Logger.i(tag, getCreatedObject());
    }

    abstract public T getCreatedObject();
}
