package com.example.gabekeyner.todolist20;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private float xCoordinate;
    private float yCoordinate;



    FragmentManager fragmentManager = getSupportFragmentManager();
    FloatingActionButton fab_add;


    public void populateView() {
        //Cursor cusor = DatabaseHelper.getInstance(this).getAllCanvas();
        //adapter.changeCursor(cursor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(this, R.anim.anticipate_overshoot);



    fab_add = ( FloatingActionButton)findViewById(R.id.fab);
        //FA Button to add a new Canvas

//        fab_add.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch(motionEvent.getActionMasked()){
//                    case MotionEvent.ACTION_DOWN:
//                        xCoordinate = view.getX() - motionEvent.getRawX();
//                        yCoordinate = view.getY() - motionEvent.getRawY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        view.animate().x(motionEvent.getRawX() + xCoordinate).y(motionEvent.getRawY() + yCoordinate).setDuration(0).start();
//                        break;
//                    default:
//                        return false;
//                }
//                Fragment_DialogActivity Fragment_dialog = new Fragment_DialogActivity();
//                Fragment_dialog.show(fragmentManager,"Alert Dialog Fragment");
//
//                return true;
//            }
//        });
//        fab_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fab_add.startAnimation(ro);
//            }
//        });

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_add.startAnimation(animAnticipateOvershoot);

                Fragment_DialogActivity Fragment_dialog = new Fragment_DialogActivity();
                Fragment_dialog.show(fragmentManager,"Alert Dialog Fragment");


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //Search Bar
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
