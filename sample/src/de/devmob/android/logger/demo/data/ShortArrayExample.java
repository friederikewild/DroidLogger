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

public class ShortArrayExample extends ObjectExample<short[]>
{
    private final short[] shortArray = { 0, 3, 42, -99, Short.MIN_VALUE, Short.MAX_VALUE };

    public ShortArrayExample()
    {
        initWithTitleFromCreatedObject("short[]:");
    }

    public short[] getCreatedObject()
    {
        return shortArray;
    }
}
