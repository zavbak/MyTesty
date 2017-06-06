package ru.anit.alex.mytests.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.anit.alex.mytests.app.App;

/**
 * Created by user on 06.06.2017.
 */

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return context;
    }
}
