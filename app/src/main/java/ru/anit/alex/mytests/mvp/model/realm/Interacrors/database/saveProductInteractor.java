package ru.anit.alex.mytests.mvp.model.realm.Interacrors.database;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmModel;
import ru.anit.alex.mytests.app.App;
import ru.anit.alex.mytests.mvp.model.realm.intities.Product;
import rx.Observable;

/**
 * Created by user on 07.06.2017.
 */

public class saveProductInteractor implements Interactor {

    @Inject
    Realm mRealm;

    Product mProduct;


    private  <E extends RealmModel> long getNextId(Class<E> clazz) {

        long id = 1;

        try {
            id = mRealm.where(Product.class).max("id").intValue() + 1;
        } catch (Exception e) {

        }

        return id;
    }

    public saveProductInteractor(Product product) {
        mProduct = product;
        App.getAppComponent().injectCreateProductInteractor(this);

    }

    @Override
    public Observable getObservable() {
        Product realmProduct;

        try {
            mRealm.beginTransaction();
            if (mProduct.getId() == 0) {
                mProduct.setId(getNextId(Product.class));
                realmProduct = mRealm.createObject(Product.class);
            }else{



            }

            mRealm.commitTransaction();

            return Observable.just(realmProduct);
        } catch (Exception e) {
            e.printStackTrace();
            mRealm.cancelTransaction();
            return Observable.error(e);

        }

    }
}
