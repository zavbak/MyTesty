package ru.anit.alex.mytests.ui.activiyies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.anit.alex.mytests.R;
import ru.anit.alex.mytests.mvp.presenters.MainPr;
import ru.anit.alex.mytests.mvp.view.MainView;
import ru.anit.alex.mytests.ui.fragments.FragmentHello;
import ru.anit.alex.mytests.ui.fragments.FragmentRelm;

public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @InjectPresenter
    MainPr mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        setTitle("lkjhlkjnlknmjlk");

        init();
    }


    void init(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
        CharSequence title = item.getTitle();

        mPresenter.onNavigationItemSelected(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.fab)
    void onClickFab(){
        mPresenter.onClickFab();
    }


    @Override
    public void showSnackbarView(@NonNull CharSequence text) {
        Snackbar.make(fab, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void setTitleView(@NonNull CharSequence text) {
        setTitle(text);
    }

    @Override
    public void setFragmentFragmentRelmView() {

        getFragmentManager().findFragmentById(R.id.fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, FragmentRelm.getInstance(),FragmentRelm.TAG)
                .commit();
    }


    @Override
    public void setFragmentHelloView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, FragmentHello.getInstance())
                .commit();

    }
}
