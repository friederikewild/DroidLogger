DroidLogger
=============

The DroidLogger is an Android library project to simplify and wrap logging on Android. An additional class allows string formatting of all kind of object types including null references and collections that don't have useful default toString methods.


Project overview
----------------
* [lib](https://github.com/friederikewild/DroidLogger/tree/master/lib) - The library project that can be referenced from an Android project.
* [sample](https://github.com/friederikewild/DroidLogger/tree/master/sample) - An Android demo app that demonstrates how to use and configure the DroidLogger.


How to use
----------
* Just log as known from android Log class, but using the `Logger` class
* Or just use the `ToStringFormatter` utils to get a nice readable output of arrays, list, cursors, objects that may be `null` - whatever you are using
* To avoid string cocatenating - even when the call is removed via preprocessor - use the extended logging calls, that allow multiple input values. These will only be added together if logging for this loglevel is enabled using the `ToStringFormatter`
* Set the wanted log level with

    ```java
    Logger.MIN_ACTIVATED_LOG_LEVEL = Log.DEBUG;
    ```


###Getting Started (Eclipse)
Import the DroidLogger project to your workspace and add a reference to it from your project. All needed steps can be found at [developer.android: Referencing a library project](https://developer.android.com/tools/projects/projects-eclipse.html#ReferencingLibraryProject)


Developed By
============

* The initial version was written by  <a href="https://plus.google.com/117518039262793648233?rel=author">Friederike Wild</a> - <friederike.wild@devmob.de>


License
=======

    Copyright 2013 Friederike Wild

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
