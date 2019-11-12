package com.example.contextmenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class showsidra extends AppCompatActivity implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener {
    Intent t2;
    boolean onoff;
    Double multiplier,firstvar;
    Double[] arr;
    ListView lv;
    TextView sumorind;
    int pos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsidra);
        lv = (ListView)findViewById(R.id.lv);
        sumorind = (TextView)findViewById(R.id.sumorind);

        t2 = getIntent();
        multiplier = t2.getDoubleExtra("mulanddif",-345345345);
        firstvar = t2.getDoubleExtra("firstvar",-1.1111);
        onoff = t2.getBooleanExtra("ariorgeo",true);

        arr=createarr(onoff,multiplier,firstvar);//generates the progression

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, R.layout.support_simple_spinner_dropdown_item,arr);
        lv.setAdapter(adp);
        lv.setOnCreateContextMenuListener(this);
        lv.setOnItemLongClickListener(this);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        menu.add("index");
        menu.add("sum");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        pos=position+1;
        return false;
    }

   @Override
    public boolean onContextItemSelected(MenuItem item){//shows sum or index within the textview
        String str = item.getTitle().toString();
        if(str.equals("index"))sumorind.setText("Index: "+pos);
        else sumorind.setText("Sum: "+sum(arr,pos));



        return true;
    }


    //returns the progression according to the boolean condition -- if true return geometrical else return arithmetic
    public static Double[] createarr(boolean bool,Double mulordif,Double firstvar){
        Double[] arr = new Double[20];
        arr[0]=firstvar;
        if(bool) {
            for (int i = 2; i <= 20; i++) {
                arr[i - 1] = arr[0] * Math.pow(mulordif, i - 1);

            }
        }else
            for (int i = 2; i <= 20; i++) {
                arr[i - 1] = arr[0] + mulordif*(i-1);

            }

        return arr;
    }

    //returns the sum of values between indexes 0>>pos
    public static Double sum(Double[] arr,int pos){
        Double sum = 0.0;
        for(int i = 0;i<pos;i++){
            sum+=arr[i];
        }
        return sum;
    }


}
