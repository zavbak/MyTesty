package ru.anit.alex.mytests.mvp.view;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/*

AddToEndStrategy – добавит пришедшую команду в конец очереди. Используется по умолчанию
AddToEndSingleStrategy – добавит пришедшую команду в конец очереди команд. Причём, если команда такого типа уже есть в очереди, то уже существующая будет удалена
SingleStateStrategy – очистит всю очередь команд, после чего добавит себя в неё
SkipStrategy – команда не будет добавлена в очередь, и никак не изменит очередь

*/
public interface MainView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showSnackbarView(@NonNull CharSequence text);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setTitleView(@NonNull CharSequence text);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void setFragmentFragmentRelmView();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void setFragmentHelloView();
}
