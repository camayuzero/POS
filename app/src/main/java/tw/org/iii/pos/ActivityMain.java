package tw.org.iii.pos;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectsPagerAdapter = new SelectsPagerAdapter(getSupportFragmentManager());
        InitialComponent();
    }

    private class SelectsPagerAdapter extends FragmentPagerAdapter {

        public SelectsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            //根據目前tab標籤頁的位置，傳回對應的fragment物件
            switch (position) {
                case 0:
                    fragment = new DrinksTeaFragment();
                    break;
                case 1:
                    fragment = new DrinksMilkTeaFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "純茶類";
                case 1 :
                    return "奶茶類";
                default:
                    return null;
            }

        }
    }

    private void InitialComponent() {
        viewPager = findViewById(R.id.viewPager_Drinks);
        viewPager.setAdapter(selectsPagerAdapter);
        tabLayout = findViewById(R.id.tabLayout_Drinks);
        //設定viewPager給tabLayout，就會顯示tab pages
        tabLayout.setupWithViewPager(viewPager);
    }

    SelectsPagerAdapter selectsPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
}
