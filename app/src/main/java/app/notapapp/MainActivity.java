package app.notapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // saving and loading use the same class
    SLData saveClicker;
    SLData loadClicker;
    TEArea textEditArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEditArea = new TEArea(this, findViewById(R.id.text_edit));
        saveClicker = new SLData(this, findViewById(R.id.save_button), textEditArea);
        loadClicker = new SLData(this, findViewById(R.id.load_button), textEditArea);
        loadClicker.changeState();
    }
}