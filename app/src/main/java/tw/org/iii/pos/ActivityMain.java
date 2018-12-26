package tw.org.iii.pos;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityMain extends AppCompatActivity implements Interface_DrinksFragment{

    public POS_Factory Get_POS_Factory() {
        return pos_factory;
    }
    public SharedPreferences Get_SharedPreferences() {
        return sharedPreferences;
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

        drinksTeaFragment = new DrinksTeaFragment();
        drinksMilkTeaFragment = new DrinksMilkTeaFragment();
        amountFragment = new AmountFragment();
        displayFragment = new DisplayFragment();

        //fragmentTransaction.add(容器,片段,TAG_標記名稱);
        fragmentTransaction.add(R.id.fragmentDisplay, displayFragment, pos_factory
                .TAG_DisplayFragment);
        fragmentTransaction.add(R.id.fragmentAmount, amountFragment, pos_factory
                .TAG_AmountFragment);
        fragmentTransaction.commit();   //啟動Fragment處理流程的執行續
        fragmentManager.executePendingTransactions();   //立刻執行

        sharedPreferences = getSharedPreferences(pos_factory.KEY_drink, MODE_PRIVATE);

        selectsPagerAdapter = new SelectsPagerAdapter(fragmentManager);
        InitialComponent();
    }

    @Override
    public void Set_commodity_name(String commodity_name) {
        try {
            sharedPreferences.edit().putString(pos_factory.KEY_drink_name,commodity_name);
            amountFragment.Set_commodity_name(commodity_name);
        } catch (Exception e) {
            Log.d("Set_commodity_name", e.getMessage());
        }
    }

    @Override
    public void Set_commodity_price(String commodity_price) {
        try {
            sharedPreferences.edit().putString(pos_factory.KEY_drink_price,commodity_price);
            amountFragment.Set_commodity_price(commodity_price);
        } catch (Exception e) {
            Log.d("Set_commodity_price", e.getMessage());
        }
    }

    @Override
    public void Set_commodity_quantity(String commodity_quantity) {
        try {
            sharedPreferences.edit().putString(pos_factory.KEY_drink_quantity,commodity_quantity);
            amountFragment.Set_commodity_quantity(commodity_quantity);
        } catch (Exception e) {
            Log.d("Set_commodity_quantity", e.getMessage());
        }
    }

    @Override
    public void Set_commodity_clear() {
        sharedPreferences.edit().remove(pos_factory.KEY_drink_name);
        sharedPreferences.edit().remove(pos_factory.KEY_drink_price);
        sharedPreferences.edit().remove(pos_factory.KEY_drink_quantity);
        amountFragment.Set_commodity_clear();
    }

    @Override
    public void Set_commodity_confirm() {
        if(null==sharedPreferences.getString(pos_factory.KEY_drink_name,null)){
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
            builder.setMessage("未選擇飲料");
            builder.show();
            return;
        }
        if(null==sharedPreferences.getString(pos_factory.KEY_drink_quantity,null)){
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
            builder.setMessage("未設定數量");
            builder.show();
            return;
        }

        //
        amountFragment.Set_commodity_clear();
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
//                    fragmentTransaction.replace(R.id.fragment_drinks_tea, drinksTeaFragment, pos_factory
//                            .TAG_DrinksTeaFragment);
//                    fragmentTransaction.commit();
//                    fragmentManager.executePendingTransactions();
                    return drinksTeaFragment;
                case 1:
//                    fragmentTransaction.replace(R.id.fragment_drinks_milktea, drinksMilkTeaFragment, pos_factory
//                            .TAG_DrinksMilkTeaFragment);
//                    fragmentTransaction.commit();
//                    fragmentManager.executePendingTransactions();
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
