package com.sjjkk.tearythm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sjjkk.tearythm.Nearby.NearbyFragment;
import com.sjjkk.tearythm.daily.DailyFragment;
import com.sjjkk.tearythm.recommand.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    Fragment thisFragment;
    List<Fragment> fragments = new ArrayList<>();
    DailyFragment dailyFragment;
    RecommendFragment recommendFragment;
    NearbyFragment nearbyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我们？", Snackbar.LENGTH_LONG)
                        .setAction("邮件", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Intent.ACTION_SENDTO);
                                intent.setData(Uri.parse("mailto:bjfu_tea@163.com"));
                                startActivity(intent);
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dailyFragment = new DailyFragment();
        recommendFragment = RecommendFragment.newInstance("","");
        nearbyFragment = NearbyFragment.newInstance("","");
        switchToDaily();
        drawer.openDrawer(Gravity.START);

//        fragments.add(dailyFragment);
//        fragments.add(recommendFragment);
//        fragments.add(nearbyFragment);

//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        hideFragment(fragmentTransaction);
//        fragmentTransaction.commit();

    }


    @Override
    protected void onResume() {
        super.onResume();





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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_daily) {
            // Handle the camera action
            switchToDaily();
        } else if (id == R.id.nav_recommend) {
            switchToRecommend();

        } else if (id == R.id.nav_tea_house_nearby) {
            switchToMap();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchToMap() {
        setTitle("附近茶馆");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        hideFragment(fragmentTransaction);
//        fragmentTransaction.show(nearbyFragment);
        fragmentTransaction.replace(R.id.content_main,nearbyFragment);

        fragmentTransaction.commit();
    }

    private void switchToRecommend() {
        setTitle("茶品优推");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        hideFragment(fragmentTransaction);
//        fragmentTransaction.show(recommendFragment);
        fragmentTransaction.replace(R.id.content_main,recommendFragment);


        fragmentTransaction.commit();
    }

    private void switchToDaily() {
        setTitle("每日一茶");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        hideFragment(fragmentTransaction);
//        fragmentTransaction.show(dailyFragment);
        fragmentTransaction.replace(R.id.content_main,dailyFragment);


        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        if(dailyFragment!= null){
            transaction.hide(dailyFragment);
        }
        if(nearbyFragment != null){
            transaction.hide(nearbyFragment);
        }
        if(recommendFragment != null){
            transaction.hide(recommendFragment);
        }
    }

}
