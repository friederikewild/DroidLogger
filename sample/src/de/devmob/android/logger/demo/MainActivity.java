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
package de.devmob.android.logger.demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import de.devmob.android.logger.demo.data.Example;
import de.devmob.android.logger.demo.data.ExampleCreator;

/**
 * Simple main activity of the demo application to show the usage of the
 * enhanced logging.
 * 
 * @author Friederike Wild
 */
public class MainActivity extends ListActivity
{
    private static final String TAG = "LoggerExample";
    private ExampleCreator example;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        example = new ExampleCreator(this);
        ListAdapter adapter = new ExampleAdapter(this, example.getExamples());
        setListAdapter(adapter);

        // Log all the examples. Same output on logcat as shown on screen
        for (Example object : example.getExamples())
        {
            object.log(TAG);
        }
    }

    @Override
    protected void onStop()
    {
        for (Example object : example.getExamples())
        {
            object.close();
        }
        example = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_info:
            {
                showDialog(R.id.dialog_info);
                return true;
            }
        }

        // Default handling
        return super.onOptionsItemSelected(item);
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateDialog(int)
     */
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case R.id.dialog_info:
            {
                // Create the requested dialog
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher)
                        .setTitle(R.string.menu_info).setNeutralButton(android.R.string.ok, null);

                // Add a custom text view to enable a clickable link
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                final View textEntryView = layoutInflater.inflate(R.layout.layout_text_dialog, null);
                TextView messageTextView = ((TextView) textEntryView.findViewById(R.id.textMessage));
                messageTextView.setText(Html.fromHtml(this.getResources().getString(R.string.text_info)));
                messageTextView.setMovementMethod(LinkMovementMethod.getInstance());

                dialogBuilder.setView(textEntryView);

                return dialogBuilder.create();
            }
        }

        return null;
    }

    private class ExampleAdapter extends ArrayAdapter<Example>
    {
        ExampleAdapter(Context context, Example[] examples)
        {
            super(context, R.layout.example_listitem, R.id.titleText, examples);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View view = super.getView(position, convertView, parent);
            TextView titleView = (TextView) view.findViewById(R.id.titleText);
            TextView standardView = (TextView) view.findViewById(R.id.standardText);
            TextView formattedView = (TextView) view.findViewById(R.id.formattedText);

            Example example = getItem(position);
            titleView.setText(example.title);
            standardView.setText(example.standard);
            formattedView.setText(example.example);
            return view;
        }
    }
}
