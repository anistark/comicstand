package me.anirudha.comicstand;

import android.app.Application;
import android.content.Context;

/**
 * Created by AniStark on 08/08/15.
 */
public class ComicStandApplication extends Application {
    private static ComicStandApplication mMaterialDesignApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mMaterialDesignApplication = this;
    }


    public static ComicStandApplication getApplication() {
        return mMaterialDesignApplication;
    }

    public static Context getApplicationCtx() {
        return mMaterialDesignApplication.getApplicationContext();
    }
}
