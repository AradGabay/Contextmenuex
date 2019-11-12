package com.example.contextmenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tgb;
    EditText mulordif,whatfirstvar;
    boolean onoff = false;
    double multiplier,firstvar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tgb = (ToggleButton)findViewById(R.id.tgb);
        mulordif = (EditText)findViewById(R.id.muloradd);
        whatfirstvar = (EditText)findViewById(R.id.whatfirstvar);


    }

    //changes the EditText's hint whenever the toggle button is pressed
    public void checkcondition(View view) {
        if (tgb.isChecked()) {
            mulordif.setHint("Set multiplier");
        } else mulordif.setHint("Set difference");
        onoff = !onoff;
    }

    public void showfirst20(View view) {
        if(!mulordif.getText().toString().equals("")||!whatfirstvar.getText().toString().equals("")) {

            multiplier = Double.parseDouble(mulordif.getText().toString());
            firstvar = Double.parseDouble(whatfirstvar.getText().toString());

            Intent t1 = new Intent(this, showsidra.class);
            t1.putExtra("ariorgeo", onoff);
            t1.putExtra("mulanddif", multiplier);
            t1.putExtra("firstvar", firstvar);
            startActivity(t1);

        }else
            Toast.makeText(this, "Enter valid values", Toast.LENGTH_SHORT).show();
    }

}
