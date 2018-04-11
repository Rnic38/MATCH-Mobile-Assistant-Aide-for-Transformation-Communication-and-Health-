package com.example.ryan.testapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();

        }
    }
    //code to be used if we want to add a logout button or a settings button in the future. Refer to main.xml for the xml file in regards to what we include
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        android.support.v4.app.Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new android.support.v4.app.Fragment();
        } else if (id == R.id.nav_generalInformation) {
            fragment = new Menu1();
        } else if (id == R.id.nav_generalInformationASOA) {
            fragment = new Menu2();
        } else if (id == R.id.nav_whoWeAre) {
            fragment = new Menu3();
        } else if (id == R.id.nav_resources) {
            fragment = new Menu4();
        } else if (id == R.id.nav_generalInformationCDC) {
            fragment = new SubMenu1();
        } else if (id == R.id.nav_signsandsymptomsNIMH) {
            fragment = new NIMHsigns();
        } else if (id == R.id.nav_signsandsymptomsASOA) {
            fragment = new ASOAsigns();
        } else if (id == R.id.nav_signsandsymptomsCDC) {
            fragment = new CDCsigns();
        } else if (id == R.id.nav_causesNIMH) {
            fragment = new NIMHcause();
        } else if (id == R.id.nav_causesCDC) {
            fragment = new CDCcause();
        } else if (id == R.id.nav_causesASOA) {
            fragment = new ASOAcause();
        } else if (id == R.id.nav_treatmentNIMH){
            fragment = new NIMHtreatment();
        } else if (id == R.id.nav_treatmentCDC){
            fragment = new CDCtreatment();
        } else if (id == R.id.nav_treatmentASOA){
            fragment = new ASOAtreatment();
        }

        if(fragment != null){
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(R.id.screen_area, fragment);

            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
