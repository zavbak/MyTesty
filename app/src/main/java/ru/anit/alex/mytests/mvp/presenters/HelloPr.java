package ru.anit.alex.mytests.mvp.presenters;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.ButterKnife;
import ru.anit.alex.mytests.R;
import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.view.HelloView;



@InjectViewState
public class HelloPr extends MvpPresenter<HelloView> {

    @BindString(R.string.text_hello) String textHello;

    @Inject
    Context appContext;

    public HelloPr() {
        App.getAppComponent().injectHelloPr(this);
    }

    public void onStart() {
         getViewState().showTvMessage(appContext.getResources().getString(R.string.text_hello));
    }
}
