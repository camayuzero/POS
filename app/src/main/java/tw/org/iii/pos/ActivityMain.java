package tw.org.iii.pos;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.zip.DeflaterInputStream;

public class ActivityMain extends AppCompatActivity {

    public POS_Factory Get_POS_Factory() {
        return pos_factory;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos_factory = new POS_Factory();
        //取得片段管理員
        fragmentManager = getSupportFragmentManager();
        //取得交易物件
        fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(容器,片段,TAG_標記名稱);
        fragmentTransaction.add(R.id.viewPager_Drinks, new DrinksTeaFragment(), pos_factory
                .TAG_DrinksTeaFragment);
        fragmentTransaction.add(R.id.viewPager_Drinks, new DrinksMilkTeaFragment(), pos_factory
                .TAG_DrinksMilkTeaFragment);
        fragmentTransaction.add(R.id.fragmentDisplay, new DisplayFragment(), pos_factory
                .TAG_DisplayFragment);
        fragmentTransaction.add(R.id.fragmentAmount, new AmountFragment(), pos_factory
                .TAG_AmountFragment);
        fragmentTransaction.commit();   //啟動Fragment處理流程的執行續
        fragmentManager.executePendingTransactions();   //立刻執行

        selectsPagerAdapter = new SelectsPagerAdapter(fragmentManager);
        InitialComponent();
    }

    private class SelectsPagerAdapter extends FragmentPagerAdapter {

        FragmentManager fm;

        public SelectsPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            //根據目前tab標籤頁的位置，傳回對應的fragment物件
            switch (position) {
                case 0:

//                    fragment = new DrinksTeaFragment();
                    Log.d("kk","01");
                    DrinksTeaFragment drinksTeaFragment = (DrinksTeaFragment)fm.findFragmentByTag(pos_factory.TAG_DrinksTeaFragment);
                    Log.d("kk",String.valueOf((DrinksTeaFragment)fm.findFragmentByTag(pos_factory.TAG_DrinksTeaFragment) == null));
                    fragment = drinksTeaFragment;
                    Log.d("kk",String.valueOf(fragment == null));
                    Log.d("kk",String.valueOf(fragment.getClass()));
                    break;
                case 1:
//                    fragment = new DrinksMilkTeaFragment();
                    Log.d("kk","02");
                    DrinksMilkTeaFragment drinksMilkTeaFragment = (DrinksMilkTeaFragment)
 fm.findFragmentById(R.id.fragment_drinks_milktea);
                    Log.d("kk",String.valueOf((DrinksMilkTeaFragment)fm.findFragmentByTag(pos_factory.TAG_DrinksMilkTeaFragment) == null));
                    fragment = drinksMilkTeaFragment;
                    Log.d("kk",String.valueOf(fragment == null));
                    break;
            }
            Log.d("kk",String.valueOf(fragment.getId()));
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
                case 1:
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

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SelectsPagerAdapter selectsPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    POS_Factory pos_factory;
}
