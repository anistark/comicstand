package me.anirudha.comicstand.interfaces.home;

import java.util.List;

/**
 * Created by AniStark on 08/08/15.
 */
public interface HomeView {
    void loadViewComponents();

    void initPresenter();

    void loadSectionsTabs();

    void loadViewPager(List<String> listTitleTabs);

    void setColorTabs(int color);

    void setDividerColorTabs(int color);

    void setIndicatorColorTabs(int color);

    void loadTabs();
}
