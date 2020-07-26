package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Member Variable
    EditText nameInput;
    EditText emailInput;
    Button loginBtn;
    String emailIn, nameInp;
    String log = "log";
    String MyPREFERENCES = "pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        loginBtn = findViewById ( R.id.loginBtn );
        emailInput = findViewById ( R.id.emailInput );
        nameInput = findViewById ( R.id.nameInput );


//        emailIn = emailInput.getText().toString();
//        // Log Cat
//        Log.d (log, "Email input is: " + emailIn);
//        nameInp = nameInput.getText ().toString ();
//        Log.d (log, "Name input is: " + nameInp);
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences ( this );

        loginBtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                emailIn = emailInput.getText ().toString ();
                nameInp = nameInput.getText ().toString ();
                Log.d ( log, "Email Input is: " + emailIn );
                Log.d ( log, "Name Input is: " + nameInp );

                emailInput.setText ( emailIn );
                nameInput.setText ( nameInp );

                SharedPreferences.Editor editor = sharedPreferences.edit ();

                editor.putString ( "emailKey", emailIn );
                editor.putString ( "nameKey", nameInp );
                editor.apply ();

                String name = sharedPreferences.getString ( "nameKey", nameInp );
                Log.d ( log, "Name Key: " + name );

                String emailAddress = sharedPreferences.getString ( "emailKey", emailIn );
                emailInput.setText ( name );
                nameInput.setText ( emailAddress );


            }
        } );


    }

}

