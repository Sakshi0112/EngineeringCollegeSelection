package com.sak.engineeingcollegeselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText changepassword_o,changepassword_n,email,confirmpass;
    Button reset,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = (EditText)findViewById(R.id.email);
        changepassword_o = (EditText)findViewById(R.id.changePassword_o);
        changepassword_n = (EditText)findViewById(R.id.changePassword_n);
        reset = (Button)findViewById(R.id.reset);
        save = (Button)findViewById(R.id.save);
        confirmpass = (EditText)findViewById(R.id.confirmpass);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepassword_o.setText("");
                changepassword_n.setText("");
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  e = email.getText().toString();
                String email1 = helper.searchEmail(e);
                if (email1.equals(e)) {
                    if (confirmpass.getText().toString().equals(changepassword_n.getText().toString())) {
                        boolean isUpdated = helper.resetPassword(changepassword_n.getText().toString(), email.getText().toString());
                        if (isUpdated == true) {
                            Intent i = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                            Toast.makeText(ForgotPasswordActivity.this, "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, "Password not updated", Toast.LENGTH_SHORT).show();
                    }
                    if (!confirmpass.getText().toString().equals(changepassword_n.getText().toString()))
                    {
                        confirmpass.setError("Passwords don't match");
                    }
                }
                else
                {
                    Toast.makeText(ForgotPasswordActivity.this, "Wrong email id is entered and Password not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
      Intent i = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
