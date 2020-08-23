package com.sak.engineeingcollegeselection;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView signUp,info,forgotPassword;
    Button login;
    EditText username,password;
    private int counter = 5;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPassword = (TextView)findViewById(R.id.forgotPassword);
        info = (TextView)findViewById(R.id.textView7);
        signUp = (TextView)findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        info.setText("No of Attempts Remaining : 5");
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                if(username.getText().toString().equals("") && password.getText().toString().equals(""))
                {
                    username.setError("Enter Valid Username");
                    password.setError("Enter Valid Password");
                }
                else
                {
                    if (password.getText().toString().equals(""))
                    {
                        password.setError("Enter Valid Password");
                    }
                    else
                    {
                        if (username.getText().toString().equals(""))
                        {
                            username.setError("Enter Valid Username");
                        }
                        else
                        {
                            if (username.getText().toString().equals("admin@123") && password.getText().toString().equals("Admin@123"))
                            {
                                Intent i = new Intent(LoginActivity.this,AdminActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else {
                                String password = helper.searchPassword(uname);
                                if (pass.equals(password)) {
                                    Toast.makeText(LoginActivity.this, "Successful!", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginActivity.this,NavigationUserActivity.class);
                                    startActivity(i);
                                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                                    finish();
                                } else {
                                    counter --;
                                    info.setText("No. of Attempts Remaining:"+String.valueOf(counter));
                                    if (counter == 0){
                                        login.setEnabled(false);
                                    }
                                    Toast.makeText(LoginActivity.this, "Invalid Credentails!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(LoginActivity.this);
        b.setTitle("Really Exit?");
        b.setMessage("Are you Sure?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoginActivity.super.onBackPressed();
            }
        }).setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert = b.create();
        alert.show();
    }
}
