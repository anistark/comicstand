package me.anirudha.comicstand.repository;

import android.content.res.Resources;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import me.anirudha.comicstand.ComicStandApplication;
import me.anirudha.comicstand.utility.BusProvider;
import me.anirudha.comicstand.R;
import me.anirudha.comicstand.events.LoadColorsTabsDisk;
import me.anirudha.comicstand.events.LoadTitleTabsDisk;
import me.anirudha.comicstand.interfaces.home.HomeRepository;

/**
 * Created by AniStark on 08/08/15.
 */
public class HomeRepositoryDiskImpl implements HomeRepository {
    private static final String TAG = HomeRepositoryDiskImpl.class.getSimpleName();

    public HomeRepositoryDiskImpl() {
        BusProvider.getInstance().register(this);
    }

    @Override
    public void recoverTitleTabs() {
        try {
            List<String> listTitleTabs = Arrays.asList(ComicStandApplication.getApplicationCtx().getResources().getStringArray(R.array.fragment_home_sections_tabs_title));

            BusProvider.getInstance().post(new LoadTitleTabsDisk(listTitleTabs));
        } catch (Resources.NotFoundException notFoundExcepetion) {
            Log.e(TAG, "Error Getting The Array", notFoundExcepetion);
        }
    }

    @Override
    public void recoverColorsTabs() {
        BusProvider.getInstance().post(new LoadColorsTabsDisk(getColorTab(), getDividerColorTab(), getIndicatorColorTab()));
    }

    @Override
    public int getColorTab() {
        return ComicStandApplication.getApplicationCtx().getResources().getColor(android.R.color.white);

    }

    @Override
    public int getDividerColorTab() {
        return ComicStandApplication.getApplicationCtx().getResources().getColor(R.color.theme_dialer_primary);
    }

    @Override
    public int getIndicatorColorTab() {
        return ComicStandApplication.getApplicationCtx().getResources().getColor(android.R.color.transparent);
    }

    @Override
    public void onDestroy() {
        BusProvider.getInstance().unregister(this);
    }
}
