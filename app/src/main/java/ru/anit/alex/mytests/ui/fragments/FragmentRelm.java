package ru.anit.alex.mytests.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.anit.alex.mytests.R;
import ru.anit.alex.mytests.mvp.presenters.RealmPr;
import ru.anit.alex.mytests.mvp.view.RealmView;

/**
 * Created by user on 06.06.2017.
 */

public class FragmentRelm extends MvpAppCompatFragment implements RealmView {

    @InjectPresenter
    RealmPr mPresenter;

    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.btAddBarcode)
    Button btAddBarcode;

    public static FragmentRelm getInstance() {
        FragmentRelm fragment = new FragmentRelm();

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_realm, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btShowState)
    void onClickShowState(){
        mPresenter.onClickShowState();
    }

    @OnClick(R.id.btAddBarcode)
    void onClickBtAddBarcode(){
        mPresenter.onClickBtAddBarcode();
    }



    @Override
    public void showTvMessageView(@NonNull CharSequence text) {
        tvMessage.setText(text);
    }
}
