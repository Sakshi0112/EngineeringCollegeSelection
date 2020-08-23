package com.sak.engineeingcollegeselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopUserActivity extends AppCompatActivity {

    String[] collegename1 ={
            "Army Institute of Technology[AIT]",
            "Bharati Vidyapeeth Deemed University College Of Engineering",
            "College of Engineering Pune [COEP]",
            "ISBM School of Technology",
            "MAEERS Maharashtra Institute of Technology (MIT)",
            "MKSSS Cummins College of Engineering for Women",
            "Pune Institute of Computer Technology",
            "Sinhgad Academy of Engineering",
            "Symbiosis International University (SIU)",
            "Vishwakarma Institute of Technology"
    };

    Integer[] imgid1={
            R.drawable.ait_logo,
            R.drawable.bvdu,
            R.drawable.coep_logo,
            R.drawable.isbm_logo,
            R.drawable.mit_logo,
            R.drawable.cummines_logo,
            R.drawable.pictl,
            R.drawable.sinhgad_logo,
            R.drawable.symbosis_logo,
            R.drawable.vit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_user);

        CustomAdapter1 adapter1 = new CustomAdapter1(this, collegename1, imgid1);
        final ListView list=(ListView)findViewById(R.id.list1);
        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position==0){
                    Intent intent = new Intent(TopUserActivity.this,TopUserActivity1.class);
                    intent.putExtra("Top Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==1){
                    Intent intent = new Intent(TopUserActivity.this,TopUserActivity2.class);
                    intent.putExtra("Top Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==2){
                    Intent intent = new Intent(TopUserActivity.this,TopUserActivity3.class);
                    intent.putExtra("Top Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==3){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity4.class);
                    intent.putExtra("Top Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==4){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity5.class);
                    intent.putExtra("Top Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==5){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity6.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==6){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity7.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==7){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity8.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==8){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity9.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }

                if (position==9){
                    Intent intent = new Intent(TopUserActivity.this, TopUserActivity10.class);
                    intent.putExtra("Colleges", list.getItemIdAtPosition(position));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in,R.anim.move);
                }
            }
        });
    }
}
