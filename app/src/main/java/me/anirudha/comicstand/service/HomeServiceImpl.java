package me.anirudha.comicstand.service;

import me.anirudha.comicstand.interfaces.home.HomeService;
import me.anirudha.comicstand.repository.HomeRepositoryDiskImpl;

/**
 * Created by AniStark on 08/08/15.
 */
public class HomeServiceImpl implements HomeService {
    private static final String TAG = HomeServiceImpl.class.getSimpleName();
    private HomeRepositoryDiskImpl mHomeRepositoryDisk;

    public HomeServiceImpl() {
        mHomeRepositoryDisk = new HomeRepositoryDiskImpl();
    }

    @Override
    public void recoverTitleTabs() {
        mHomeRepositoryDisk.recoverTitleTabs();
    }

    @Override
    public void recoverColorTabs() {
        mHomeRepositoryDisk.recoverColorsTabs();
    }

    @Override
    public void onDestroy() {
        mHomeRepositoryDisk.onDestroy();
        mHomeRepositoryDisk = null;
    }
}
