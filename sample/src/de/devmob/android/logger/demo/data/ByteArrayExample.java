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

public class ByteArrayExample extends ObjectExample<byte[]>
{
    private final byte[] byteArray = { 8, 3, 1, Byte.MIN_VALUE, Byte.MAX_VALUE };

    public ByteArrayExample()
    {
        initWithTitleFromCreatedObject("byte[]:");
    }

    public byte[] getCreatedObject()
    {
        return byteArray;
    }
}
