package ru.anit.alex.mytests.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.GetAllBarcodeInteracor;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.SaveBarcodeInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Barcode;
import ru.anit.alex.mytests.mvp.view.RealmView;
import rx.Subscriber;
import rx.internal.util.ActionSubscriber;

/**
 * Created by user on 06.06.2017.
 */

@InjectViewState
public class RealmPr extends MvpPresenter<RealmView> {


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onClickShowState() {

        GetAllBarcodeInteracor interacor = new GetAllBarcodeInteracor(0);
        interacor.execute(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                List<Barcode> list = (List) o;

                String strMessage = "Show barcode: \n";

                for(Barcode barcode: list){
                    strMessage = strMessage + "\n" + barcode.toString();
                }

                getViewState().showTvMessageView(strMessage);

            }
        });


    }

    public void onClickBtAddBarcode() {
        Barcode barcode = new Barcode();
        barcode.setBarcode("56456456456456");
        barcode.setPlaces(1);
        barcode.setWeight((float) 2.5);

        SaveBarcodeInteractor interactor = new SaveBarcodeInteractor(barcode,0);
        interactor.execute(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        });


    }
}
