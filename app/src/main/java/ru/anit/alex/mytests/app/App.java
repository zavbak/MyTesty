package ru.anit.alex.mytests.app;

import android.app.Application;


import io.realm.Realm;
import ru.anit.alex.mytests.di.AppModule;
import ru.anit.alex.mytests.di.AppComponent;
import ru.anit.alex.mytests.di.DaggerAppComponent;


/**
 * Created by user on 06.06.2017.
 */

public class App extends Application{

    private static AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        init();


    }

    /*
    Инициализация всего
     */
    void init(){
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Realm.init(this);
        Realm.setDefaultConfiguration(mAppComponent.getRealmConfiguration());

    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
