package com.sak.engineeingcollegeselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class UserActivity3 extends AppCompatActivity {

    TextView textView3,textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user3);

            textView4 = (TextView)findViewById(R.id.textView4);
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
