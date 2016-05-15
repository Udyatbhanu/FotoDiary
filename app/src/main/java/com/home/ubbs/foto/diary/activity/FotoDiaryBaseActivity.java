package com.home.ubbs.foto.diary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.home.ubbs.foto.diary.R;
import com.home.ubbs.foto.diary.session.AppSession;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

/**
 * Created by udyatbhanu-mac on 5/11/16.
 */
public abstract class FotoDiaryBaseActivity extends AppCompatActivity  implements
        NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    FloatingActionButton floatingActionButton;
    public boolean isHome() {
        return isHome;
    }

    protected void setHome(boolean home) {
        isHome = home;
    }

    boolean isHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID){

        super.setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        setUpIcons(menu);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.GONE);

        ViewStubCompat stub = (ViewStubCompat)findViewById(R.id.child_layout_stub);
        stub.setLayoutResource(layoutResID);
        stub.inflate();



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
    public void onResume(){
        super.onResume();
        navigationView.getMenu().getItem(AppSession.selectedItem).setChecked(true);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = null;
        int id = item.getItemId();

        if (id == R.id.home) {
            AppSession.selectedItem = 0;

        } else if (id == R.id.new_album) {
            AppSession.selectedItem = 1;
            intent = new Intent(this, NewAlbumActivity.class);
            startActivity(intent);


        } else if (id == R.id.gallery) {

            AppSession.selectedItem = 2;
        } else if (id == R.id.settings) {
            AppSession.selectedItem = 3;
        } else if (id == R.id.feedback) {
            AppSession.selectedItem = 4;
        } else if (id == R.id.help) {
            AppSession.selectedItem = 5;
        }

        if(!isHome){
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setUpIcons(Menu menu){

        MenuItem home = menu.findItem(R.id.home);
        home.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_home).
                color(getResources().getColor(R.color.home_icon)));

        MenuItem newAlbum = menu.findItem(R.id.new_album);
        newAlbum.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_plus).
                color(getResources().getColor(R.color.new_album_icon)));

        MenuItem gallery = menu.findItem(R.id.gallery);
        gallery.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_eye).
                color(getResources().getColor(R.color.gallery_icon)));

        MenuItem settings = menu.findItem(R.id.settings);
        settings.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_cog).
                color(getResources().getColor(R.color.settings_icon)));

        MenuItem feedback = menu.findItem(R.id.feedback);
        feedback.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_envelope).
                color(getResources().getColor(R.color.feedback_icon)));


        MenuItem help = menu.findItem(R.id.help);
        help.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_question).
                color(getResources().getColor(R.color.help_icon)));



    }


}
