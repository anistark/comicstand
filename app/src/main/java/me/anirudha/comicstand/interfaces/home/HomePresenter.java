package me.anirudha.comicstand.interfaces.home;

import com.squareup.otto.Subscribe;

import me.anirudha.comicstand.events.LoadColorsTabsDisk;
import me.anirudha.comicstand.events.LoadTitleTabsDisk;

/**
 * Created by AniStark on 08/08/15.
 */
public interface HomePresenter {
    void loadSectionsTabs();

    @Subscribe
    void onLoadTitleTabsDiskSuccess(LoadTitleTabsDisk loadTitleTabsDisk);

    @Subscribe
    void onLoadColorTabsDiskSuccess(LoadColorsTabsDisk loadColorsTabsDisk);

    void onDestroy();
}
