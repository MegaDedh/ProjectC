package ru.startandroid.myapk3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnWeb;
    Button btnMap;
    Button btnCall;
    Button btnHelp;
    Button btnVibr1;
    Button btnVibr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnVibr1 = (Button) findViewById(R.id.btnVibr1);
        btnVibr2 = (Button) findViewById(R.id.btnVibr2);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnVibr1.setOnClickListener(this);
        btnVibr2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        switch (v.getId()) {
            case R.id.btnWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://java.com/ru/"));
                startActivity(intent);
                break;
            case R.id.btnMap:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:55.754283,37.62002"));
                startActivity(intent);
                break;
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                startActivity(intent);
                break;
            case R.id.btnHelp:
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "+79184912106"));
                startActivity(intent);
                break;
            case R.id.btnVibr1:

                vib.vibrate(1500);
                Toast.makeText(getApplicationContext(), "Жужим просто", Toast.LENGTH_LONG).show();

                break;
            case R.id.btnVibr2:

                long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
                vib.vibrate(pattern, -1);
                Toast.makeText(getApplicationContext(), "Жужим сложно", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
