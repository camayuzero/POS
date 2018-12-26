package tw.org.iii.pos;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksMilkTeaFragment extends Fragment {

    private View.OnClickListener button_Commodity11_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                interface_drinksFragment.Set_commodity_name(sharedPreferences.getString
                        (pos_factory.KEY_drink_name, button_Commodity11_Name.getText().toString()));
                interface_drinksFragment.Set_commodity_price(sharedPreferences.getString
                        (pos_factory.KEY_drink_price, textView_Commodity11_Price.getText()
                                .toString()));
            } catch (Exception e) {
                Log.d("kkk1", e.getMessage());
            }
        }
    };

    private View.OnClickListener button_Commodity12_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                interface_drinksFragment.Set_commodity_name(sharedPreferences.getString
                        (pos_factory.KEY_drink_name, button_Commodity12_Name.getText().toString()));
                interface_drinksFragment.Set_commodity_price(sharedPreferences.getString
                        (pos_factory.KEY_drink_price, textView_Commodity12_Price.getText()
                                .toString()));
            } catch (Exception e) {
                Log.d("kkk1", e.getMessage());
            }
        }
    };

    private View.OnClickListener button_Commodity13_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                interface_drinksFragment.Set_commodity_name(sharedPreferences.getString
                        (pos_factory.KEY_drink_name, button_Commodity13_Name.getText().toString()));
                interface_drinksFragment.Set_commodity_price(sharedPreferences.getString
                        (pos_factory.KEY_drink_price, textView_Commodity13_Price.getText()
                                .toString()));
            } catch (Exception e) {
                Log.d("kkk1", e.getMessage());
            }
        }
    };

    private View.OnClickListener button_Commodity14_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                interface_drinksFragment.Set_commodity_name(sharedPreferences.getString
                        (pos_factory.KEY_drink_name, button_Commodity14_Name.getText().toString()));
                interface_drinksFragment.Set_commodity_price(sharedPreferences.getString
                        (pos_factory.KEY_drink_price, textView_Commodity14_Price.getText()
                                .toString()));
            } catch (Exception e) {
                Log.d("kkk1", e.getMessage());
            }
        }
    };

    private View.OnClickListener button_Commodity15_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                interface_drinksFragment.Set_commodity_name(sharedPreferences.getString
                        (pos_factory.KEY_drink_name, button_Commodity15_Name.getText().toString()));
                interface_drinksFragment.Set_commodity_price(sharedPreferences.getString
                        (pos_factory.KEY_drink_price, textView_Commodity15_Price.getText()
                                .toString()));
            } catch (Exception e) {
                Log.d("kkk1", e.getMessage());
            }
        }
    };

    public DrinksMilkTeaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (null != context) {
            activityMain = (ActivityMain) context;
            interface_drinksFragment = (Interface_DrinksFragment) context;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_milktea, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pos_factory = activityMain.Get_POS_Factory();
        sharedPreferences = activityMain.Get_SharedPreferences();
        InitialComponent();
    }

    private void InitialComponent() {
        button_Commodity11_Name = getView().findViewById(R.id.button_Commodity11_Name);
        button_Commodity11_Name.setOnClickListener(button_Commodity11_Name_click);
        button_Commodity12_Name = getView().findViewById(R.id.button_Commodity12_Name);
        button_Commodity12_Name.setOnClickListener(button_Commodity12_Name_click);
        button_Commodity13_Name = getView().findViewById(R.id.button_Commodity13_Name);
        button_Commodity13_Name.setOnClickListener(button_Commodity13_Name_click);
        button_Commodity14_Name = getView().findViewById(R.id.button_Commodity14_Name);
        button_Commodity14_Name.setOnClickListener(button_Commodity14_Name_click);
        button_Commodity15_Name = getView().findViewById(R.id.button_Commodity15_Name);
        button_Commodity15_Name.setOnClickListener(button_Commodity15_Name_click);
        textView_Commodity11_Price = getView().findViewById(R.id.textView_Commodity11_Price);
        textView_Commodity12_Price = getView().findViewById(R.id.textView_Commodity12_Price);
        textView_Commodity13_Price = getView().findViewById(R.id.textView_Commodity13_Price);
        textView_Commodity14_Price = getView().findViewById(R.id.textView_Commodity14_Price);
        textView_Commodity15_Price = getView().findViewById(R.id.textView_Commodity15_Price);
    }

    Button button_Commodity11_Name;
    Button button_Commodity12_Name;
    Button button_Commodity13_Name;
    Button button_Commodity14_Name;
    Button button_Commodity15_Name;
    TextView textView_Commodity11_Price;
    TextView textView_Commodity12_Price;
    TextView textView_Commodity13_Price;
    TextView textView_Commodity14_Price;
    TextView textView_Commodity15_Price;

    private POS_Factory pos_factory;
    private SharedPreferences sharedPreferences;
    private ActivityMain activityMain;
    private Interface_DrinksFragment interface_drinksFragment;
}
