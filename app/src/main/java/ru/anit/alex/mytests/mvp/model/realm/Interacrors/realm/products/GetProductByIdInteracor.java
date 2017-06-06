package ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.products;

import io.realm.Realm;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.BaseInteractor;
import ru.anit.alex.mytests.mvp.model.realm.intities.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex on 02.06.2017.
 */

public class GetProductByIdInteracor extends BaseInteractor {
    Realm realm = Realm.getDefaultInstance();
    long mId;

    public GetProductByIdInteracor(long id) {
        super(AndroidSchedulers.mainThread(), AndroidSchedulers.mainThread());
        mId = id;
    }

    @Override
    protected Observable<Product> getObservable() {
        try {
            Product results = realm.where(Product.class).equalTo("id", mId).findFirst();
            return Observable.just(results);

        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            return Observable.error(e);
        }
    }
}
