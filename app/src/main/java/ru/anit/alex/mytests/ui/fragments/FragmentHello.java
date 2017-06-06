package ru.anit.alex.mytests.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.anit.alex.mytests.R;
import ru.anit.alex.mytests.mvp.presenters.HelloPr;
import ru.anit.alex.mytests.mvp.view.HelloView;

/**
 * Created by user on 06.06.2017.
 */

public class FragmentHello extends MvpAppCompatFragment implements HelloView {

    @BindView(R.id.tvMessage)
    TextView tvMessage;


    @InjectPresenter
    HelloPr mPresenter;



    public static FragmentHello getInstance() {
        FragmentHello fragment = new FragmentHello();

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_hello, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    @Override
    public void showTvMessage(@NonNull CharSequence text) {
        tvMessage.setText(text);
    }
}
