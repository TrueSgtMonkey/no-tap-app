package app.notapapp;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// handles the information we need for the text editing for our current page
public class TEArea
{
    private String text;
    private AppCompatActivity activity;
    private EditText textComponent;

    public TEArea(AppCompatActivity activity, EditText textComponent)
    {
        this.activity = activity;
        this.textComponent = textComponent;
        text = "";
        textComponent.setText(text);
    }

    public void overwriteText(String text)
    {
        this.text = text;
        textComponent.setText(text);
    }
    public String receiveText()
    {
        text = textComponent.getText().toString();
        return text;
    }

}
