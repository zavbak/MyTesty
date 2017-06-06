package ru.anit.alex.mytests.mvp.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


public interface RealmView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showTvMessageView(@NonNull CharSequence text);
}
