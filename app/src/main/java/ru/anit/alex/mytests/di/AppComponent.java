package ru.anit.alex.mytests.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.RealmConfiguration;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.database.saveProductInteractor;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.DellAllBarcodeInteractor;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.GetAllBarcodeInteracor;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.SaveBarcodeInt;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.SaveBarcodeInteractor;
import ru.anit.alex.mytests.mvp.presenters.HelloPr;
import ru.anit.alex.mytests.mvp.presenters.MainPr;

@Singleton
@Component(modules={AppModule.class,RealmModule.class})
public interface AppComponent {
    Context getContext();
    void injectHelloPr(HelloPr helloPr);
    void injectMainPr(MainPr mainPr);
    RealmConfiguration getRealmConfiguration();

    void injectDellAllBarcodeInteractor(DellAllBarcodeInteractor dellAllBarcodeInteractor);
    void injectSaveBarcodeInteractor(SaveBarcodeInteractor saveBarcodeInteractor);
    void injectGetAllBarcodeInteracor(GetAllBarcodeInteracor getAllBarcodeInteracor);

    void injectSaveBarcode(SaveBarcodeInt saveBarcodeInt);

    void injectCreateProductInteractor(saveProductInteractor createProductInteractor);
}
