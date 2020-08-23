package com.sak.engineeingcollegeselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class UserActivity extends AppCompatActivity {

    String[] collegename ={"Zeal College of Engineering and Research"
            "Abhinav Education Society's College of Engineering and Technology",
            "Bharati Vidyapeeth Deemed University College Of Engineering",
            "Bharati Vidyapeeth's College of Engineering For Women",
            "Pune Institute of Computer Technology",
            "Universal College of Engineering and Research",
            "Vishwakarma Institute of Technology",

    };

    Integer[] imgid={
            R.drawable.abhinav,
            R.drawable.bvdu,
            R.drawable.bvcoew,
            R.drawable.pictl,
            R.drawable.universall,
            R.drawable.vit,
            R.drawable.zeal
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        CustomAdapter adapter=new CustomAdapter(this, collegename, imgid);
        final ListView list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position==0){
                    Intent intent = new Intent(UserActivity.this, UserActivity1.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==1){
                    Intent intent = new Intent(UserActivity.this, UserActivity2.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==2){
                    Intent intent = new Intent(UserActivity.this, UserActivity3.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==3){
                    Intent intent = new Intent(UserActivity.this, UserActivity4.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==4){
                    Intent intent = new Intent(UserActivity.this, UserActivity5.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==5){
                    Intent intent = new Intent(UserActivity.this, UserActivity6.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==6){
                    Intent intent = new Intent(UserActivity.this, UserActivity7.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

            }
        });
    }
}
