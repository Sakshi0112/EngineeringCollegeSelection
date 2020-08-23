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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    TextView login;
    Button submit,reset;
    EditText username,name,email_id,password,confirmPassword;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login =(TextView)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        submit = (Button)findViewById(R.id.save);
        reset = (Button)findViewById(R.id.reset);
        username = (EditText)findViewById(R.id.username);
        name = (EditText)findViewById(R.id.name);
        email_id = (EditText)findViewById(R.id.email_id);
        password = (EditText)findViewById(R.id.password);
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("") && username.getText().toString().equals("") && email_id.getText().toString().equals("") && password.getText().toString().equals("") && confirmPassword.getText().toString().equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (name.getText().toString().equals("")) {
                        Toast.makeText(RegisterActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                        name.setError("Enter valid Name");
                    } else
                    {
                        if (username.getText().toString().equals("")) {
                            Toast.makeText(RegisterActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                            username.setError("Enter valid Username");
                        }
                        if (!isValidUserName(username.getText().toString())) {
                            username.setError("User Name is invalid");
                        }
                        else
                        {
                            if (email_id.getText().toString().equals("")) {
                                Toast.makeText(RegisterActivity.this, "Enter Email id", Toast.LENGTH_SHORT).show();
                                email_id.setError("Enter valid email_id");
                            }
                            if (!isValidEmail(email_id.getText().toString())) {
                                email_id.setError("invalid Email");
                            }
                            else
                            {
                                if (password.getText().toString().equals("")) {
                                    Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                                    password.setError("Enter valid Password");
                                }
                                else
                                {
                                    if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
                                        if (confirmPassword.getText().toString().equals("")) {
                                            Toast.makeText(RegisterActivity.this, "Enter Confirm Password Again", Toast.LENGTH_SHORT).show();
                                        }
                                        confirmPassword.setError("Passwords don't match");
                                    }else
                                    {
                                        if (!((confirmPassword.length()>=6) && (password.length()>= 6)))
                                        {
                                            Toast.makeText(RegisterActivity.this, "Password must be atleast 6 characters", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                                Contacts c = new Contacts();
                                                c.setName(name.getText().toString());
                                                c.setUsername(username.getText().toString());
                                                c.setEmail_id(email_id.getText().toString());
                                                c.setPassword(password.getText().toString());
                                                String  e = email_id.getText().toString();
                                                String email1 = helper.searchEmail(e);
                                                String n = name.getText().toString();
                                                String name1 = helper.searchName(n);
                                                if (!email1.equals(e)){
                                                    if (!name1.equals(n)) {
                                                        helper.insertContact(c);
                                                        Toast.makeText(RegisterActivity.this, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
                                                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                                        startActivity(i);
                                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                        finish();
                                                    }
                                                    else {
                                                        name.setError("Name already Exists");
                                                        Toast.makeText(RegisterActivity.this, "Name exists!", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                else {
                                                    email_id.setError("Email_id already exists!");
                                                    Toast.makeText(RegisterActivity.this, "Email_id already exists!", Toast.LENGTH_SHORT).show();
                                                }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                username.setText("");
                email_id.setText("");
                password.setText("");
                confirmPassword.setText("");
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(RegisterActivity.this);
        b.setTitle("Really Exit?");
        b.setMessage("Are you Sure?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RegisterActivity.super.onBackPressed();
                    }
                }).setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert = b.create();
        alert.show();
    }

    private boolean isValidUserName(String username) {
        if (username != null) {
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
