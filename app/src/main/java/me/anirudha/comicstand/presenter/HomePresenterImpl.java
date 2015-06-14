package me.anirudha.comicstand.presenter;

import com.squareup.otto.Subscribe;

import me.anirudha.comicstand.events.LoadColorsTabsDisk;
import me.anirudha.comicstand.events.LoadTitleTabsDisk;
import me.anirudha.comicstand.interfaces.home.HomePresenter;
import me.anirudha.comicstand.interfaces.home.HomeView;
import me.anirudha.comicstand.service.HomeServiceImpl;
import me.anirudha.comicstand.utility.BusProvider;

/**
 * Created by AniStark on 08/08/15.
 */
public class HomePresenterImpl implements HomePresenter {
    private static final String TAG = HomePresenterImpl.class.getSimpleName();
    private HomeView mHomeView;
    private HomeServiceImpl mHomeService;

    public HomePresenterImpl(HomeView homeView) {
        BusProvider.getInstance().register(this);
        mHomeView = homeView;
        mHomeService = new HomeServiceImpl();
    }

    @Override
    public void loadSectionsTabs() {
        mHomeService.recoverTitleTabs();
    }

    @Subscribe
    public void onLoadTitleTabsDiskSuccess(LoadTitleTabsDisk loadTitleTabsDisk) {
        mHomeView.loadViewPager(loadTitleTabsDisk.getListTitleTabs());
        mHomeService.recoverColorTabs();
    }

    @Subscribe
    public void onLoadColorTabsDiskSuccess(LoadColorsTabsDisk loadColorsTabsDisk) {
        mHomeView.setColorTabs(loadColorsTabsDisk.getColorTab());
        mHomeView.setDividerColorTabs(loadColorsTabsDisk.getDividerColorTab());
        mHomeView.setIndicatorColorTabs(loadColorsTabsDisk.getIndicatorColorTab());
        mHomeView.loadTabs();
    }

    @Override
    public void onDestroy() {
        BusProvider.getInstance().unregister(this);
        mHomeService.onDestroy();
        mHomeService = null;
    }
}
