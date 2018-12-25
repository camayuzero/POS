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

public class ActivityMain extends AppCompatActivity implements Interface_AmountFragment,
        Interface_DrinksTeaFragment {

    public POS_Factory Get_POS_Factory() {
        return pos_factory;
    }

    public SharedPreferences Get_SharedPreferences() {
        return sharedPreferences;
    }

    public Fragment Get_DrinksTeaFragment() {
        return drinksTeaFragment;
    }

    public Fragment Get_DrinksMilkTeaFragment() {
        return drinksMilkTeaFragment;
    }

    public Fragment Get_AmountFragment() {
        return amountFragment;
    }

    public Fragment Get_DisplayFragment() {
        return displayFragment;
    }

//    public void Set_commodity_name(String commodity_name){
//        ((AmountFragment)amountFragment).Set_commodity_name(commodity_name);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos_factory = new POS_Factory();
        //取得片段管理員
        fragmentManager = getSupportFragmentManager();
        //取得交易物件
        fragmentTransaction = fragmentManager.beginTransaction();

        drinksTeaFragment = new DrinksTeaFragment();
        drinksMilkTeaFragment = new DrinksMilkTeaFragment();
        amountFragment = new AmountFragment();
        displayFragment = new DisplayFragment();
        //fragmentTransaction.add(容器,片段,TAG_標記名稱);
//        fragmentTransaction.add(R.id.viewPager_Drinks, new DrinksTeaFragment(), pos_factory
//                .TAG_DrinksTeaFragment);
//        fragmentTransaction.add(R.id.viewPager_Drinks, new DrinksMilkTeaFragment(), pos_factory
//                .TAG_DrinksMilkTeaFragment);
        fragmentTransaction.add(R.id.fragmentDisplay, displayFragment, pos_factory
                .TAG_DisplayFragment);
        fragmentTransaction.add(R.id.fragmentAmount, amountFragment, pos_factory
                .TAG_AmountFragment);
        fragmentTransaction.commit();   //啟動Fragment處理流程的執行續
        fragmentManager.executePendingTransactions();   //立刻執行

        sharedPreferences = getSharedPreferences(pos_factory.KEY_drink, MODE_PRIVATE);

//        drinksTeaFragment = fragmentManager.findFragmentByTag(pos_factory.TAG_DrinksTeaFragment);
//        drinksMilkTeaFragment = fragmentManager.findFragmentByTag(pos_factory
// .TAG_DrinksMilkTeaFragment);
//        amountFragment = fragmentManager.findFragmentByTag(pos_factory.TAG_AmountFragment);
//        displayFragment = fragmentManager.findFragmentByTag(pos_factory.TAG_DisplayFragment);

        selectsPagerAdapter = new SelectsPagerAdapter(fragmentManager);
        InitialComponent();
    }

    @Override
    public void Set_commodity_name(String commodity_name) {
        try {
            amountFragment.Set_commodity_name(commodity_name);
        } catch (Exception e) {
            Log.d("Set_commodity_name01", e.getMessage());
        }
    }

    @Override
    public void Set_commodity_price(String commodity_price) {
        try {
            amountFragment.Set_commodity_price(commodity_price);
        } catch (Exception e) {
            Log.d("Set_commodity_name01", e.getMessage());
        }
    }

    @Override
    public void Call_Set_commodity_name(String commodity_name) {
        Set_commodity_name(commodity_name);
    }

    @Override
    public void Call_Set_commodity_price(String commodity_price) {
        Set_commodity_price(commodity_price);
    }

    private class SelectsPagerAdapter extends FragmentPagerAdapter {

        public SelectsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //根據目前tab標籤頁的位置，傳回對應的fragment物件
            switch (position) {
                case 0:
                    return drinksTeaFragment;
                case 1:
                    return drinksMilkTeaFragment;
            }
            return null;
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

    private POS_Factory pos_factory;
    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SelectsPagerAdapter selectsPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DrinksTeaFragment drinksTeaFragment;
    private DrinksMilkTeaFragment drinksMilkTeaFragment;
    private AmountFragment amountFragment;
    private DisplayFragment displayFragment;
}
