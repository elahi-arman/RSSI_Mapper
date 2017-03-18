package com.example.armanelahi.rssi_mapper;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RSSILocatorActivity extends AppCompatActivity {

    private FileOutputStream fos;
    private EditText locationEditText;
    private Button button;
    private WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssilocator);

        button = (Button) findViewById(R.id.new_entry_button);
        locationEditText = (EditText) findViewById(R.id.location_tag);

        button.setOnClickListener(onClickListener);
        wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        try {
            fos = openFileOutput("savedData.txt",  MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {

            try {

                List<ScanResult> results = wm.getScanResults();
                Log.d("RSSI", results.toString());
                fos.write("herpderp".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
