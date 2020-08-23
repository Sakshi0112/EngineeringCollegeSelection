package com.sak.engineeingcollegeselection;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminActivity extends AppCompatActivity {

    Button gotoC;
    TextView details;
    DatabaseHelper helper = new DatabaseHelper(this);
    public static String FILENAME = "LoginDetails.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        details = (TextView)findViewById(R.id.details);
        gotoC = (Button)findViewById(R.id.gotoColl);
        gotoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this,NavigationUserActivity.class);
                startActivity(i);
                finish();
            }
        });
        viewAll();
        readFile();
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();
    }

    public void viewAll(){
        Cursor res = helper.selectAll();
        if (res.getCount() == 0){
            showAll("Error", "No data");
            return;
        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()){
                buffer.append("ID:"+res.getString(0)+"\n");
                buffer.append("Name:"+res.getString(1)+"\n");
                buffer.append("Username:"+res.getString(2)+"\n");
                buffer.append("Email_Id:"+res.getString(3)+"\n");
                buffer.append("Password:"+res.getString(4)+"\n\n");
            }

            if(isExternalStorageWritable() && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                File textFile= new File(Environment.getExternalStorageDirectory(),FILENAME);
                try {
                    FileOutputStream fos = new FileOutputStream(textFile);
                    fos.write(buffer.toString().getBytes());
                    fos.close();
                    Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else{
                Toast.makeText(this, "Cannot write to external storage", Toast.LENGTH_SHORT).show();
            }
            showAll("Login Details",buffer.toString());
        }
    }

    public void showAll(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private boolean isExternalStorageWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Log.i("State","Yes, it is writable!");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkPermission(String permission){
        int check= ContextCompat.checkSelfPermission(this,permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    private boolean isExternalStorageReadable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())){
            Log.i("State","Yes it is readable!");
            return true;
        }
        else{
            return false;
        }
    }

    public void readFile(){
        if (isExternalStorageReadable())
        {
            StringBuilder sb =new StringBuilder();
            try {
                File textfile = new File(Environment.getExternalStorageDirectory(),FILENAME);
                FileInputStream fis = new FileInputStream(textfile);
                /*Toast.makeText(this,"Reading From File", Toast.LENGTH_SHORT).show();*/
                if(fis!=null){
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader buff = new BufferedReader(isr);

                    String line=null;
                    while((line = buff.readLine())!= null){
                        sb.append(line + "\n");
                    }
                    fis.close();
                }
                details.setText(sb);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this, "Cannot Read From External Storage", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(AdminActivity.this);
        b.setTitle("Really Exit?");
        b.setMessage("Are you Sure?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdminActivity.super.onBackPressed();
                    }
                }).setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert = b.create();
        alert.show();
    }
}
