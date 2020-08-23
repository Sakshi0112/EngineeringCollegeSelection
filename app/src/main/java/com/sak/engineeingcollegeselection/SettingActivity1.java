package com.sak.engineeingcollegeselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity1 extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText changepassword_o,changepassword_n,name,confirmpass;
    Button reset,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting1);

        name = (EditText)findViewById(R.id.name);
        changepassword_o = (EditText)findViewById(R.id.changePassword_o);
        changepassword_n = (EditText)findViewById(R.id.changePassword_n);
        reset = (Button)findViewById(R.id.reset);
        save = (Button)findViewById(R.id.save);
        confirmpass = (EditText)findViewById(R.id.confrimpass);

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
                String n = name.getText().toString();
                String name1 = helper.searchName(n);
                if (name1.equals(n))
                {
                    if (confirmpass.getText().toString().equals(changepassword_n.getText().toString())) {
                        boolean isUpdated = helper.updatePassword(changepassword_n.getText().toString(), name.getText().toString());
                        if (isUpdated == true) {
                            Toast.makeText(SettingActivity1.this, "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SettingActivity1.this, "Password not updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SettingActivity1.this, "Password not updated", Toast.LENGTH_SHORT).show();
                    }
                    if (!confirmpass.getText().toString().equals(changepassword_n.getText().toString()))
                    {
                        confirmpass.setError("Passwords don't match");
                    }
                }
                else {
                    Toast.makeText(SettingActivity1.this, "Name entered does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
