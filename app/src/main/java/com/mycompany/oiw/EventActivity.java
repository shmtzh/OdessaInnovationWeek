package com.mycompany.oiw;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EventActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, OnFragmentInteractionListener {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    protected OnBackPressedListener onBackPressedListener;


    public  static String EXTRA_MESSAGE = "null";
    Button location;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }


//    @Override
//    public void onBackPressed() {getActivity().getFragmentManager().popBackStack();}


    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getFragmentManager();
        Fragment f = null;

        switch (position) {
            case 0: f = TechFragment.newInstance(position );
                break;
            case 1: f = BusFragment.newInstance(position);
                break;
            case 2:f = SUFragment.newInstance(position );
                break;
            case 3:
                f = CustomMapFragment.newInstance(position);
                break;
            case 4:
                f = AboutFragment.newInstance();
                break;


        }

        fragmentManager.beginTransaction()
//                .addToBackStack()
                .replace(R.id.container, f)
//                .remove (container)
//        ft.remove(fragment);
//        ft.commit();
//                .remove()
                .commit();
    }


//    @Override
//    public void onBackPressed() {
//        // TODO Auto-generated method stub
//
//
//        FragmentManager fragmentManager = getFragmentManager();
//
//        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//            fragmentManager.popBackStack(null,
//                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        } else {
//            super.onBackPressed();
//        }
//    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.tech_events);
                break;
            case 2:
                mTitle = getString(R.string.bs_events);
                break;
            case 3:
                mTitle = getString(R.string.startup_events);
                break;
            case 4:
                mTitle = getString(R.string.map);
                break;
            case 5:
                mTitle = getString(R.string.about);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.event, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

//    public mapshow() {return}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        int id = item.getItemId();
// if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

            switch (item.getItemId()) {
                case R.id.action_example:
                    {FragmentManager fragmentManager = getFragmentManager();
                    Fragment f = null;
                    f = CustomMapFragment.newInstance(0);
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, f)
                            .commit();}
                    return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

//    public openSearch() {return 0;}



//    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
//        this.onBackPressedListener = onBackPressedListener;
//    }
//    @Override
//    public void onBackPressed() {
//        if (onBackPressedListener != null)
//            onBackPressedListener.doBack();
//        else
//            super.onBackPressed();}


    @Override
    public void onListItemClick(int id) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment f = null;
         f = DescriptionFragment.newInstance(id);

        fragmentManager.beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack("tag")
                .commit();

    }
}


