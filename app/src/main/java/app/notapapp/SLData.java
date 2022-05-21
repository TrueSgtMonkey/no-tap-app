package app.notapapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Handles all of the saving and loading of the current text file we are on
public class SLData implements View.OnClickListener
{
    //reference to the current activity
    //for things like findViewById(R.id.<id_name>) and such
    private AppCompatActivity activity;

    //everything in android programming is clickable
    private View component; // component that we are changing with clicks
    private TEArea textEditArea;

    enum DataState {
        SAVE,
        LOAD
    }
    private DataState state;

    public SLData(AppCompatActivity activity, View component, TEArea textEditArea)
    {
        this.activity = activity;
        this.component = component;
        this.textEditArea = textEditArea;
        component.setOnClickListener(this);
        state = DataState.SAVE;
    }

    public DataState getState() { return state; }
    protected void setState(DataState s) { state = s; }

    public void changeState()
    {
        switch(state)
        {
            case SAVE:
                state = DataState.LOAD;
                break;
            case LOAD:
                state = DataState.SAVE;
                break;
        }
    }

    //based on our current state, we will enter either the save/load process
    @Override
    public void onClick(View view)
    {
        switch(state)
        {
            case SAVE:
                try {
                    saveToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case LOAD:
                try {
                    loadFromFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void saveToFile() throws IOException {
        File path = activity.getApplicationContext().getFilesDir();
        File file = new File(path, "butt.txt");
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(textEditArea.receiveText().getBytes());
        }
    }

    private void loadFromFile() throws IOException
    {
        File path = activity.getApplicationContext().getFilesDir();
        File file = new File(path, "butt.txt");
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try (FileInputStream in = new FileInputStream(file)) {
            in.read(bytes);
        }

        textEditArea.overwriteText(new String(bytes));
    }
}
