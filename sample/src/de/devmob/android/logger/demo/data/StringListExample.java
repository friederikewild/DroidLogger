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

import java.util.ArrayList;
import java.util.List;

public class StringListExample extends ObjectExample<List<String> >
{
    private final List<String> stringList;

    public StringListExample()
    {
        stringList = new ArrayList<String>();
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");
        stringList.add("seven");

        initWithTitleFromCreatedObject("List<String>:");
    }

    public List<String> getCreatedObject()
    {
        return stringList;
    }
}