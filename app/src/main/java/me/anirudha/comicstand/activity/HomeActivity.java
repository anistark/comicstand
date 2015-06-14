package me.anirudha.comicstand.activity;

import android.os.Bundle;

import me.anirudha.comicstand.constants.FragmentNames;
import me.anirudha.comicstand.fragment.HomeFragment;
import me.anirudha.comicstand.R;
import me.anirudha.comicstand.activity.api.BaseActivity;


public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.screen_default_container, new HomeFragment(), FragmentNames.FRAGMENT_HOME_).commit();
        }
    }

    @Override
    protected int setLayoutResourceIdentifier() {
        return R.layout.screen_default;
    }

    @Override
    protected int getTitleToolBar() {
        return R.string.app_name;
    }

}
