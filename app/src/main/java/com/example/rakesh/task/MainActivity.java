package com.example.rakesh.task;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private ViewPager viewPager;
    private int currentpage = 0;
    private final Integer[] TOP = {R.drawable.dont_let_me_down, R.drawable.not_afraid, R.drawable.spider, R.drawable.wonder};
    private ArrayList<Integer> TopArray = new ArrayList<>();
    private final String[] header={"Don't let me down","Not Afraid","Spider-Man Homecoming","Wonder Woman"};
    private ArrayList<String> headerArray=new ArrayList<>();
    private final String[] descr={"Chainsmokers, Daya","Eminem","Tom Holland","Gal Gadot"};
    private ArrayList<String> descrArray=new ArrayList<>();
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = this.getWindow().getDecorView();                                                                           //to
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;  //dim
        decorView.setSystemUiVisibility(uiOptions);                                                                               //system bar
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HOME");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager mPager = (ViewPager) findViewById(R.id.view_pager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(myPagerAdapter);
        tabLayout.setTabsFromPagerAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(mPager);

        TabLayout.Tab vid = tabLayout.newTab();
        TabLayout.Tab img = tabLayout.newTab();
        TabLayout.Tab mil = tabLayout.newTab();
        TabLayout.Tab vr = tabLayout.newTab();
        TabLayout.Tab navmil = tabLayout.newTab();
        TabLayout.Tab about = tabLayout.newTab();
        /*
        vid.setText("VIDEOS");
        img.setText("IMAGES");
        mil.setText("MILESTONE");
        vr.setText("VR VIDEOS");
        navmil.setText("NAV MILESTONE");
        about.setText("ABOUT US");
        */
        View vid_view = getLayoutInflater().inflate(R.layout.custom_tab, null);   //custom view to add text and icon in tabs
       final ImageView iconVid = (ImageView) vid_view.findViewById(R.id.tabIcon);
       final TextView textVId = (TextView) vid_view.findViewById(R.id.tabText);
        iconVid.setImageResource(R.drawable.select_video);
        textVId.setText("VIDEOS");
        textVId.setTextColor(getResources().getColor(R.color.colorPrimary));

        View img_view = getLayoutInflater().inflate(R.layout.custom_tab, null);
       final ImageView iconImg = (ImageView) img_view.findViewById(R.id.tabIcon);
       final TextView textImg = (TextView) img_view.findViewById(R.id.tabText);
        iconImg.setImageResource(R.drawable.image);
        textImg.setText("IMAGES");


        View mil_view = getLayoutInflater().inflate(R.layout.custom_tab, null);
       final ImageView iconMil = (ImageView) mil_view.findViewById(R.id.tabIcon);
       final TextView textMil = (TextView) mil_view.findViewById(R.id.tabText);
        iconMil.setImageResource(R.drawable.milestone);
        textMil.setText("MILESTONE");


        View vr_view = getLayoutInflater().inflate(R.layout.custom_tab, null);
       final ImageView iconVr = (ImageView) vr_view.findViewById(R.id.tabIcon);
       final TextView textVr = (TextView) vr_view.findViewById(R.id.tabText);
        iconVr.setImageResource(R.drawable.vr_videos);
        textVr.setText("VR VIDEOS");


        View nmil_view = getLayoutInflater().inflate(R.layout.custom_tab, null);
       final ImageView iconNmil = (ImageView) nmil_view.findViewById(R.id.tabIcon);
       final TextView textNmil = (TextView) nmil_view.findViewById(R.id.tabText);
        iconNmil.setImageResource(R.drawable.navi_milestone);
        textNmil.setText("NAVIGATION MILESTONE");


        View about_view = getLayoutInflater().inflate(R.layout.custom_tab, null);
      final   ImageView iconAbt = (ImageView) about_view.findViewById(R.id.tabIcon);
        final TextView textAbt = (TextView) about_view.findViewById(R.id.tabText);
        iconAbt.setImageResource(R.drawable.about_us);
        textAbt.setText("ABOUT TEXT");

        vid.setCustomView(vid_view);
        img.setCustomView(img_view);
        mil.setCustomView(mil_view);
        vr.setCustomView(vr_view);
        navmil.setCustomView(nmil_view);
        about.setCustomView(about_view);

        tabLayout.addTab(vid, 0);
        tabLayout.addTab(img, 1);
        tabLayout.addTab(mil, 2);
        tabLayout.addTab(vr, 3);
        tabLayout.addTab(navmil, 4);
        tabLayout.addTab(about, 5);
        tabLayout.setTabTextColors(getResources().getColor(R.color.unselected), getResources().getColor(R.color.colorPrimary));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        iconVid.setImageResource(R.drawable.select_video);
                        textVId.setTextColor(getResources().getColor(R.color.colorPrimary));
                        iconImg.setImageResource(R.drawable.image);
                        textImg.setTextColor(getResources().getColor(R.color.unselected));
                        iconMil.setImageResource(R.drawable.milestone);
                        textMil.setTextColor(getResources().getColor(R.color.unselected));
                        iconVr.setImageResource(R.drawable.vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.unselected));
                        iconNmil.setImageResource(R.drawable.navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.unselected));
                        iconAbt.setImageResource(R.drawable.about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 1:
                        iconVid.setImageResource(R.drawable.video);
                        textVId.setTextColor(getResources().getColor(R.color.unselected));
                        iconImg.setImageResource(R.drawable.select_image);
                        textImg.setTextColor(getResources().getColor(R.color.colorPrimary));
                        iconMil.setImageResource(R.drawable.milestone);
                        textMil.setTextColor(getResources().getColor(R.color.unselected));
                        iconVr.setImageResource(R.drawable.vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.unselected));
                        iconNmil.setImageResource(R.drawable.navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.unselected));
                        iconAbt.setImageResource(R.drawable.about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 2:
                        iconVid.setImageResource(R.drawable.video);
                        textVId.setTextColor(getResources().getColor(R.color.unselected));
                        iconImg.setImageResource(R.drawable.image);
                        textImg.setTextColor(getResources().getColor(R.color.unselected));
                        iconMil.setImageResource(R.drawable.select_milestone);
                        textMil.setTextColor(getResources().getColor(R.color.colorPrimary));
                        iconVr.setImageResource(R.drawable.vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.unselected));
                        iconNmil.setImageResource(R.drawable.navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.unselected));
                        iconAbt.setImageResource(R.drawable.about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 3:
                        iconVid.setImageResource(R.drawable.video);
                        textVId.setTextColor(getResources().getColor(R.color.unselected));
                        iconImg.setImageResource(R.drawable.image);
                        textImg.setTextColor(getResources().getColor(R.color.unselected));
                        iconMil.setImageResource(R.drawable.milestone);
                        textMil.setTextColor(getResources().getColor(R.color.unselected));
                        iconVr.setImageResource(R.drawable.select_vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.colorPrimary));
                        iconNmil.setImageResource(R.drawable.navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.unselected));
                        iconAbt.setImageResource(R.drawable.about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 4:
                        iconVid.setImageResource(R.drawable.video);
                        textVId.setTextColor(getResources().getColor(R.color.unselected));
                        iconImg.setImageResource(R.drawable.image);
                        textImg.setTextColor(getResources().getColor(R.color.unselected));
                        iconMil.setImageResource(R.drawable.milestone);
                        textMil.setTextColor(getResources().getColor(R.color.unselected));
                        iconVr.setImageResource(R.drawable.vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.unselected));
                        iconNmil.setImageResource(R.drawable.select_navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.colorPrimary));
                        iconAbt.setImageResource(R.drawable.about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 5:
                        iconVid.setImageResource(R.drawable.video);
                        textVId.setTextColor(getResources().getColor(R.color.unselected));
                        iconImg.setImageResource(R.drawable.image);
                        textImg.setTextColor(getResources().getColor(R.color.unselected));
                        iconMil.setImageResource(R.drawable.milestone);
                        textMil.setTextColor(getResources().getColor(R.color.unselected));
                        iconVr.setImageResource(R.drawable.vr_videos);
                        textVr.setTextColor(getResources().getColor(R.color.unselected));
                        iconNmil.setImageResource(R.drawable.navi_milestone);
                        textNmil.setTextColor(getResources().getColor(R.color.unselected));
                        iconAbt.setImageResource(R.drawable.select_about_us);
                        textAbt.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        slide();                                                                      //for image slider
    }

    private void slide() {
        for (int i = 0; i < TOP.length; i++)
            TopArray.add(TOP[i]);
        for (int i=0;i<header.length;i++)
            headerArray.add(header[i]);
        for (int i=0;i<descr.length;i++)
            descrArray.add(descr[i]);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(MainActivity.this, TopArray,headerArray,descrArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentpage == TOP.length) {
                    currentpage = 0;
                }
                viewPager.setCurrentItem(currentpage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4000, 4000);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);                    //to close drawer on pressing back button
        } else {
            super.onBackPressed();
        }
    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {                             //to load different fragments based on tabs selected
            switch (position) {
                case 0:
                    FragVid fragVid = new FragVid();
                    return fragVid;
                case 1:
                    FragPic fragPic = new FragPic();
                    return fragPic;
                case 2:
                    FragMilestone fragMileston = new FragMilestone();
                    return fragMileston;
                case 3:
                    FragVr fragVr = new FragVr();
                    return fragVr;
                case 4:
                    FragNavMile fragNavMile = new FragNavMile();
                    return fragNavMile;
                case 5:
                    FragAbout fragAbout = new FragAbout();
                    return fragAbout;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 6;
        }

   /* @Override
    public CharSequence getPageTitle(int position) {
        return "Tab "+position;

    }
   */
    }
}