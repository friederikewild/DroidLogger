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

import android.content.Context;

/**
 * Creator for the list of example entries with title and 
 * formatted string output.
 * 
 * @author Friederike Wild
 */
public class ExampleCreator
{
    final List<Example> examples;

    public ExampleCreator(Context context)
    {
        examples = new ArrayList<Example>();

        examples.add(new NullExample());
        examples.add(new CursorExample(context, 5));
        examples.add(new CursorExample(context, 0));

        examples.add(new StringArrayExample());
        examples.add(new CharArrayExample());
        examples.add(new BooleanArrayExample());
        examples.add(new ByteArrayExample());
        examples.add(new ShortArrayExample());
        examples.add(new IntArrayExample());
        examples.add(new LongArrayExample());
        examples.add(new FloatArrayExample());
        examples.add(new DoubleArrayExample());
        examples.add(new InfoArrayExample());        
        examples.add(new EnumArrayExample());

        examples.add(new BooleanExample());
        examples.add(new EnumExample());

        examples.add(new StringListExample());
        examples.add(new InfoSetExample());
        examples.add(new IntStringMapExample());
        examples.add(new ThrowableExample());
    }

    public Example[] getExamples()
    {
        Example[] examplesAsArray = new Example[examples.size()];
        for (int i = 0; i < examples.size(); i++)
        {
            examplesAsArray[i] = examples.get(i);
        }
        return examplesAsArray;
    }
}
