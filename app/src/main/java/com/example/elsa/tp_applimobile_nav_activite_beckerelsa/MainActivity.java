package com.example.elsa.tp_applimobile_nav_activite_beckerelsa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Constantes
    private final String EXTRA_NAME = "utilisateur";
    private final String EXTRA_PASS = "password";
    private final String EXTRA_MAIL = "mailutil";


    //Variables
    private Button create;
    private Button search;
    private TextView searchutil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = (Button)findViewById(R.id.buttoncreate);
        search = (Button) findViewById(R.id.buttonsearch);
        searchutil = (TextView)findViewById(R.id.champsearch);

        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor MyEditor = prefs.edit();



        Intent intent = getIntent();
            String stockname = intent.getStringExtra(EXTRA_NAME);
            String stockpass = intent.getStringExtra(EXTRA_PASS);
            String stockmail = intent.getStringExtra(EXTRA_MAIL);


            //Toast
            Toast.makeText(getApplicationContext(),
                    stockname, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),
                    stockpass, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),
                    stockmail, Toast.LENGTH_LONG).show();

            //Log
            //Log.w("Nom d'utilisateur :", stockname);
            //Log.w("Password :", stockpass );
            //Log.w("Mail :", stockmail);

        MyEditor.putString(stockname, stockpass);
        MyEditor.apply();


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = prefs.getString(searchutil.getText().toString(), "inconnu");
                if (test == "inconnu")
                {
                    Toast.makeText(MainActivity.this, "Inconnu", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Nom : " + searchutil.getText().toString() + ", MDP : " + test, Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    private void goToNextActivity(){
        Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
        startActivity(intent);
    }
}
