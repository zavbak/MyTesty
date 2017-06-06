package ru.anit.alex.mytests.mvp.view;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by user on 06.06.2017.
 */

public interface HelloView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showTvMessage(@NonNull CharSequence text);

}
