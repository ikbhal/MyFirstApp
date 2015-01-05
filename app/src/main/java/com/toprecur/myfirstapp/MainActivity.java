package com.toprecur.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<TextView> lstMessages;
    EditText editMessage;
    ImageButton btnSend;
    LinearLayout lytMessages;

    final String resourceName = "bubble_white_normal.9"; //which is image
    int bubbleImgResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        editMessage = (EditText) findViewById(R.id.editMessage);
        btnSend = (ImageButton) findViewById(R.id.btnSend);

        // Get layout message
        lytMessages = (LinearLayout) findViewById(R.id.lytMessages);

        // Create lstMessages
        lstMessages = new ArrayList<TextView>();


        bubbleImgResId = this.getResources().getIdentifier(resourceName,"drawable",this.getPackageName());


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this
                        ,"Message " + editMessage.getText() + " is sending .."
                        , Toast.LENGTH_LONG).show();

                // Create text view for message
                TextView tvMessage = new TextView(MainActivity.this);
                tvMessage.setTextSize(10);
                //tvMessage.setBackgroundColor(Color.GREEN);
                tvMessage.setTextColor(Color.RED);
                tvMessage.setGravity(Gravity.RIGHT);
                tvMessage.setText(editMessage.getText());


                //above context can be <ActivityClassname>.this
                Toast.makeText(getApplicationContext(), "bubbleImgResId " + bubbleImgResId , Toast.LENGTH_LONG);
                tvMessage.setBackgroundResource(bubbleImgResId);


                // Add to textView messages array
                lstMessages.add(tvMessage);

                // Add new text view message to messages layout
                lytMessages.addView(tvMessage);

                //HIde keyboard or  soft input.
                //InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                //imm.hideSoftInputFromWindow(editMessage.getWindowToken(), 0);

                // empty message edit text.
               editMessage.setText("");
            }
        });

        Parse.initialize(this, "QgRpAuuh9CiKCwQ4EOtcDhQeAQJDJWrmMP69Ruhp", "qH9WDmoUiN0bsuRHwa82NGy6VxnSYTTOS564aU70");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
