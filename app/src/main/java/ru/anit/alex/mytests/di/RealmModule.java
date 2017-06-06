package ru.anit.alex.mytests.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import ru.anit.alex.mytests.mvp.model.realm.Interacrors.realm.barcode.DellAllBarcodeInteractor;
import ru.anit.alex.mytests.mvp.model.realm.init.RealmMigration;

/**
 * Created by user on 06.06.2017.
 */

@Module
public class RealmModule {
    @Provides
    @Singleton
    RealmConfiguration provideRealmConfiguration(){
        return new RealmConfiguration.Builder()
                .schemaVersion(1)
                .migration(new RealmMigration())
                .build();
    }


    @Provides
    Realm provideRealm(){
        return Realm.getDefaultInstance();
    }


}
