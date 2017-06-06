package ru.anit.alex.mytests.mvp.presenters;


import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.anit.alex.mytests.R;
import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.view.MainView;


@InjectViewState
public class MainPr extends MvpPresenter<MainView> {

    @Inject
    Context mAppContext;

    int mCurentId;

    public MainPr() {
        App.getAppComponent().injectMainPr(this);
    }

    public void onClickFab() {
        getViewState().showSnackbarView("Click fab");
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        onNavigationItemSelected(R.id.nav_start);

    }

    public void onNavigationItemSelected(int id) {
        if (id == R.id.nav_start) {

            getViewState().setFragmentHelloView();
            getViewState().setTitleView(mAppContext.getResources().getString(R.string.text_title_hello)); //Не работает


        } else if (id == R.id.nav_realm) {
            getViewState().setFragmentFragmentRelmView();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
    }


}
