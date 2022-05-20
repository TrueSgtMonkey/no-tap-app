package app.notapapp;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Clicker implements View.OnClickListener
{
    //reference to the current activity
    //for things like findViewById(R.id.<id_name>) and such
    private AppCompatActivity activity;
    private View component; // component that we are changing with clicks

    enum State {
        DEF,
        BOTTM
    }
    private State state;

    public Clicker(AppCompatActivity activity, View component)
    {
        this.activity = activity;
        this.component = component;
        state = State.DEF;
    }

    @Override
    public void onClick(View view)
    {
        switch(state)
        {
            case DEF:
                bottmText();
                state = State.BOTTM;
                break;
            case BOTTM:
                helloText();
                state = State.DEF;
                break;
        }
    }

    private void bottmText()
    {
        ((TextView)component).setText("BOTTM GEAR M8s");
    }

    private void helloText()
    {
        ((TextView)component).setText("Hello, World!");
    }
}
