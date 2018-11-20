package com.example.p0401_layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater ltInflater = getLayoutInflater(); // получаем LayoutInflater методом getLayoutInflater

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout); // находим linLayout
        View view1 = ltInflater.inflate(R.layout.text, linLayout, true); // используем LayoutInflater для получения View-элемента из layout-файла text.xml
        LayoutParams lp1 = view1.getLayoutParams(); // считываем LayoutParams у свежесозданного view.

        Log.d(LOG_TAG, "Class of view1: " + view1.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view1: " + lp1.getClass().toString());
  //    Log.d(LOG_TAG, "Text of view1: " + ((TextView) view1).getText());

        RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.relLayout);
        View view2 = ltInflater.inflate(R.layout.text, relLayout, true);
        LayoutParams lp2 = view2.getLayoutParams();

        Log.d(LOG_TAG, "Class of view2: " + view2.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view2: " + lp2.getClass().toString());
  //    Log.d(LOG_TAG, "Text of view2: " + ((TextView) view2).getText());
    }
}