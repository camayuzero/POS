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

public class ActivityMain extends AppCompatActivity {

    public POS_Factory Get_POS_Factory(){
        return pos_factory;
    }

    public SharedPreferences Get_SharedPreferences(){
        return sharedPreferences;
    }

    public Fragment Get_DrinksTeaFragment(){
        return drinksTeaFragment;
    }

    public Fragment Get_DrinksMilkTeaFragment(){
        return drinksMilkTeaFragment;
    }

    public Fragment Get_AmountFragment(){
        return amountFragment;
    }

    public Fragment Get_DisplayFragment(){
        return displayFragment;
    }

    public void Set_commodity_name(String commodity_name){
        ((AmountFragment)amountFragment).Set_commodity_name(commodity_name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos_factory = new POS_Factory();
        sharedPreferences = getSharedPreferences(pos_factory.KEY_drink,MODE_PRIVATE);
        drinksTeaFragment = new DrinksTeaFragment();
        drinksMilkTeaFragment = new DrinksMilkTeaFragment();
        amountFragment = new AmountFragment();
        displayFragment = new DisplayFragment();

        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.commit();
//        fragmentManager.executePendingTransactions();

        selectsPagerAdapter = new SelectsPagerAdapter(fragmentManager);
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
                    fragment = drinksTeaFragment;
                    break;
                case 1:
                    fragment = drinksMilkTeaFragment;
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

    private POS_Factory pos_factory;
    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SelectsPagerAdapter selectsPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment drinksTeaFragment;
    private Fragment drinksMilkTeaFragment;
    private Fragment amountFragment;
    private Fragment displayFragment;
}
