package ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmModel;

import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.BaseInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Barcode;
import ru.anit.alex.mytests.mvp.model.realm.intities.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex on 02.06.2017.
 */

public class SaveBarcodeInteractor extends BaseInteractor {


    @Inject
    Realm realm;

    Barcode mBarcode;
    long mIdProd;


    public SaveBarcodeInteractor(Barcode barcode,long idProd) {
        super(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread());
        App.getAppComponent().injectSaveBarcodeInteractor(this);

        mBarcode = barcode;
        mIdProd = idProd;
    }



    private  <E extends RealmModel> long getNextId(Class<E> clazz) {

        long id = 1;

        try {
            id = realm.where(Barcode.class).max("id").intValue() + 1;
        } catch (Exception e) {

        }

        return id;
    }

    @Override
    protected Observable<Barcode> getObservable() {

        try {
            realm.beginTransaction();

            Boolean isNew = (mBarcode.getId()==0)?true:false;

            if (mBarcode.getId() == 0) {
                mBarcode.setId(getNextId(Barcode.class));
            }

            Barcode realmBarcode = realm.copyToRealmOrUpdate(mBarcode);

            if(isNew){
                if(mIdProd != 0){
                    Product product = realm.where(Product.class).equalTo("id", mIdProd).findFirst();
                    product.getBarcodes().add(realmBarcode);
                }

            }

            realm.commitTransaction();

            return Observable.just(realmBarcode);
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            return Observable.error(e);

        }
    }
}
