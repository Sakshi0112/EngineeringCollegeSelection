package com.sak.engineeingcollegeselection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationUserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView moving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        moving = (TextView) this.findViewById(R.id.moving);
        moving.setSelected(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder b = new AlertDialog.Builder(NavigationUserActivity.this);
            b.setTitle("Really Exit?");
            b.setMessage("Are you Sure?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    NavigationUserActivity.super.onBackPressed();
                }
            }).setNegativeButton("Cancel",null).setCancelable(false);
            AlertDialog alert = b.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(NavigationUserActivity.this,SettingsActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide,R.anim.right_slide);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            Intent i = new Intent(NavigationUserActivity.this,NavigationUserActivity.class);
            startActivity(i);
            finish();
        } else if (id == R.id.college) {
            Intent i = new Intent(NavigationUserActivity.this,UserActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide,R.anim.right_slide);
        }
        else if (id == R.id.college1) {
            Intent i = new Intent(NavigationUserActivity.this, TopUserActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide, R.anim.right_slide);
        }
        else if (id == R.id.college3) {
            Intent i = new Intent(NavigationUserActivity.this, NITActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide, R.anim.right_slide);
        }
        else if (id == R.id.college2) {
            Intent i = new Intent(NavigationUserActivity.this, IITActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide, R.anim.right_slide);
        }else if (id == R.id.settings) {
            Intent i = new Intent(NavigationUserActivity.this,SettingsActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_slide,R.anim.right_slide);
        } else if (id == R.id.logout) {
            Intent i = new Intent(NavigationUserActivity.this,LoginActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
