package com.example.farmestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String prevStarted = "yes";
    EditText etFirstName, etLastName, etPin, etConfirmPin;
    Button button_register;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if(!sharedPreferences.getBoolean(prevStarted,false)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        }
        else {
            Intent menuactivityIntent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(menuactivityIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etPin = findViewById(R.id.et_username);
        etConfirmPin = findViewById(R.id.et_password);
        button_register = (Button)findViewById(R.id.button_register);
        button_register.setOnClickListener(this::gotomenuactivity);
    }

    private void gotomenuactivity(View view) {
        Intent menuactivityIntent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(menuactivityIntent);
    }


}