package me.anirudha.comicstand.interfaces.home;

import java.util.List;

/**
 * Created by AniStark on 08/08/15.
 */
public interface HomeRepository {
    void recoverTitleTabs();

    void recoverColorsTabs();

    int getColorTab();

    int getDividerColorTab();

    int getIndicatorColorTab();

    void onDestroy();


}
