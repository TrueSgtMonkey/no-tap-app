package app.notapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Clicker clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clicker = new Clicker(this, findViewById(R.id.hello_label));
        findViewById(R.id.hello_label).setOnClickListener(clicker);
    }
}