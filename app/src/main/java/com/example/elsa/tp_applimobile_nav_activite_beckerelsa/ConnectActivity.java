package com.example.elsa.tp_applimobile_nav_activite_beckerelsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnectActivity extends AppCompatActivity {

    //Constantes
    private final String EXTRA_NAME = "utilisateur";
    private final String EXTRA_PASS = "password";
    private final String EXTRA_MAIL = "mailutil";

    //Variables
    private Button valid;
    private EditText name;
    private EditText pass;
    private EditText mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        valid = (Button)findViewById(R.id.buttonconf);
        name = (EditText) findViewById(R.id.createname);
        pass = (EditText) findViewById(R.id.createpass);
        mail = (EditText) findViewById(R.id.createmail);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });
    }

    private void goToNextActivity(){
        Intent intent = new Intent(ConnectActivity.this, MainActivity.class);

        intent.putExtra(EXTRA_NAME, name.getText().toString()) ;
        intent.putExtra(EXTRA_PASS, pass.getText().toString()) ;
        intent.putExtra(EXTRA_MAIL, mail.getText().toString()) ;

        startActivity(intent);
    }
}
