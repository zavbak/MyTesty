package ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.BaseInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Barcode;
import ru.anit.alex.mytests.mvp.model.realm.intities.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex on 02.06.2017.
 */

public class GetAllBarcodeInteracor extends BaseInteractor {
    @Inject
    Realm realm;
    long mIdProd;


    public GetAllBarcodeInteracor(long idProd) {
        super(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread());
        App.getAppComponent().injectGetAllBarcodeInteracor(this);
        mIdProd = idProd;

    }

    @Override
    protected Observable getObservable() {

        try {

            if (mIdProd != 0) {
                Product product = realm.where(Product.class).equalTo("id", mIdProd).findFirst();

                //RealmResults<Barcode> results = realm.where(Barcode.class).equalTo("product.id", mIdProd).findAll();
                return Observable.just(product.getBarcodes());
            } else {
                RealmQuery<Barcode> query = realm.where(Barcode.class);
                RealmResults<Barcode> results = query.findAll();
                return Observable.just(results);
            }

        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();

            return Observable.error(e);

        }
    }
}
