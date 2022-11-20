package com.extremebozz.skripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.extremebozz.skripsi.dataaccess.LoginAccess;

public class LoginActivity extends AppCompatActivity {

    //Set variable Session (nanti buat activity splash + dipindahin ke sana)
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String USER_ID = "useridKey";
    public static final String USERNAME = "usernameKey";

    DataHelper dHelper;
    LoginAccess loginAccess;
    SharedPreferences sharedPreferences;

    String spUsername;
    Integer spUserID;

    TextView username, password;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginAccess = new LoginAccess(getApplicationContext());

        username = findViewById(R.id.tbUsernameLogin);
        password = findViewById(R.id.tbPasswordLogin);
        signIn = findViewById(R.id.buttonSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                spUserID = sharedPreferences.getInt(USER_ID, 0);
                spUsername = sharedPreferences.getString(USERNAME, null);

                if(spUserID != 0 && username != null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                //Membuka Editor Session
                SharedPreferences.Editor editor = sharedPreferences.edit();

                boolean loginSuccess = loginAccess.readUser(username.getText().toString(), password.getText().toString(), editor);

                if(loginSuccess){
                    //Mulai Intent
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }else{
                    Toast.makeText(getApplicationContext(), "Username Atau Password Yang Dimasukan Salah!", Toast.LENGTH_LONG).show();
                }
            }
        });

        ImageView back;
        back = (ImageView) findViewById(R.id.arrowBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}