package ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode;

import javax.inject.Inject;

import io.realm.Realm;

import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.BaseInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Barcode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex on 02.06.2017.
 */

public class DellAllBarcodeInteractor extends BaseInteractor {


    @Inject
    Realm realm;


    public DellAllBarcodeInteractor() {
        super(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread());
        App.getAppComponent().injectDellAllBarcodeInteractor(this);

    }

    @Override
    protected Observable<Barcode> getObservable() {

        try {
            realm.beginTransaction();

            Barcode barcode = realm.where(Barcode.class).findFirst();
            barcode.deleteFromRealm();

            realm.commitTransaction();

            return Observable.empty();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            return Observable.error(e);

        }
    }
}
