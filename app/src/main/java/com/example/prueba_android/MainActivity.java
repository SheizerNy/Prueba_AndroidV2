package com.example.prueba_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    Button btn_saludar,btn2,btn3;
    RadioButton rb1,rb2,rb3;
    ProgressBar pb1;
    CheckBox cb1,cb2,cb3;
    RatingBar Rbar1;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_saludar = (Button) findViewById(R.id.btn_saludo);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn_3);
        rb1 = (RadioButton) findViewById(R.id.Rd_btn1);
        rb2 = (RadioButton) findViewById(R.id.Rd_btn2);
        rb3 = (RadioButton) findViewById(R.id.Rd_btn3);
        pb1 = (ProgressBar) findViewById(R.id.Pb1);
        cb1 = (CheckBox) findViewById(R.id.Cb1);
        cb2 = (CheckBox) findViewById(R.id.Cb2);
        cb3 = (CheckBox) findViewById(R.id.Cb3);
        Rbar1 = (RatingBar) findViewById(R.id.Rbar);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        itemAdapter =  new ItemAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        itemAdapter.setData(getData());
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        btn_saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pb();
                Toast.makeText(MainActivity.this, "Bienvenido Usuario", Toast.LENGTH_SHORT).show();
            }
        });

        Comprobar_Rb1();
        Comprobar_Rb2();
        Comprobar_Rb3();
        }

    private List<Items> getData() {
        List<Items> list = new ArrayList<>();
        list.add(new Items(R.drawable.ichika,"Ichika"));
        list.add(new Items(R.drawable.nino, "Nino"));
        list.add(new Items(R.drawable.miku, "Miku"));
        list.add(new Items(R.drawable.yotsuba, "Yotsuba"));
        list.add(new Items(R.drawable.itsuki, "Itsuki"));
        return list;
    }

    public void Comprobar_Rb1(){
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "Tu genero es: "+tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Comprobar_Rb2(){
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "Tu genero es: "+tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Comprobar_Rb3(){
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb3.getText().toString();
                Toast.makeText(MainActivity.this, "Tu genero es: "+tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Pb(){
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                contador++;
                pb1.setProgress(contador);
                    if(contador==100){
                        t.cancel();
                    }
            }
        };
        t.schedule(tt,0,100);
    }

    public void Verificar_Cb(View v){
        String comprobar_cb1 = "";
        String comprobar_cb2 = "";
        String comprobar_cb3 = "";
        String aux = "";
        if (cb1.isChecked()==true){
            comprobar_cb1 = cb1.getText().toString();
        }
        if(cb2.isChecked()==true){
            comprobar_cb2 = cb2.getText().toString();
        }
        if(cb3.isChecked()==true){
            comprobar_cb3 = cb3.getText().toString();
        }
        if(comprobar_cb1=="" && comprobar_cb2=="" && comprobar_cb3 == ""){
            Toast.makeText(MainActivity.this,"Ninguna opcion seleccionada",Toast.LENGTH_SHORT).show();
        }else{
            aux = (comprobar_cb1+" "+comprobar_cb2+" "+comprobar_cb3);
            Toast.makeText(MainActivity.this, "Las opciones seleccionadas fueron: "+aux, Toast.LENGTH_SHORT).show();
        }
    }

    public void Num_Stars(View v){
        Toast.makeText(MainActivity.this, "Usted ha calificado esta app con " +Rbar1.getRating()+ " estrellas", Toast.LENGTH_SHORT).show();
    }


}