package ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode;

import io.realm.Realm;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.BaseInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Barcode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex on 02.06.2017.
 */

public class GetBarcodeByIdInteracor extends BaseInteractor {
    Realm realm = Realm.getDefaultInstance();
    long mId;

    public GetBarcodeByIdInteracor(long id) {
        super(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread());
        mId = id;
    }

    @Override
    protected Observable<Barcode> getObservable() {
        try {
            Barcode results = realm.where(Barcode.class).equalTo("id", mId).findFirst();
            return Observable.just(results);

        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            return Observable.error(e);
        }
    }
}
