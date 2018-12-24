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
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksTeaFragment extends Fragment {

    private View.OnClickListener button_Commodity01_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try{
                sharedPreferences.edit().putString(pos_factory.KEY_drink_name,button_Commodity01_Name.getText().toString());
                activityMain.Set_commodity_name();

            }catch (Exception e){
                Log.d("kkk1",e.getMessage());
            }
        }
    };

    private View.OnClickListener button_Commodity02_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pos_factory.setDrink_name(button_Commodity02_Name.getText().toString());
        }
    };

    private View.OnClickListener button_Commodity03_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pos_factory.setDrink_name(button_Commodity03_Name.getText().toString());
        }
    };

    private View.OnClickListener button_Commodity04_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pos_factory.setDrink_name(button_Commodity04_Name.getText().toString());
        }
    };

    private View.OnClickListener button_Commodity05_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pos_factory.setDrink_name(button_Commodity05_Name.getText().toString());
        }
    };

    private View.OnClickListener button_Commodity06_Name_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pos_factory.setDrink_name(button_Commodity06_Name.getText().toString());
        }
    };



    public DrinksTeaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_tea, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityMain = (ActivityMain)context;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pos_factory = activityMain.Get_POS_Factory();
        sharedPreferences = activityMain.Get_SharedPreferences();
        amountFragment = (AmountFragment) activityMain.Get_AmountFragment();
        InitialComponent();
    }

    private void InitialComponent() {
        button_Commodity01_Name = getView().findViewById(R.id.button_Commodity01_Name);
        button_Commodity01_Name.setOnClickListener(button_Commodity01_Name_click);
        button_Commodity02_Name = getView().findViewById(R.id.button_Commodity02_Name);
        button_Commodity02_Name.setOnClickListener(button_Commodity02_Name_click);
        button_Commodity03_Name = getView().findViewById(R.id.button_Commodity03_Name);
        button_Commodity03_Name.setOnClickListener(button_Commodity03_Name_click);
        button_Commodity04_Name = getView().findViewById(R.id.button_Commodity04_Name);
        button_Commodity04_Name.setOnClickListener(button_Commodity04_Name_click);
        button_Commodity05_Name = getView().findViewById(R.id.button_Commodity05_Name);
        button_Commodity05_Name.setOnClickListener(button_Commodity05_Name_click);
        button_Commodity06_Name = getView().findViewById(R.id.button_Commodity06_Name);
        button_Commodity06_Name.setOnClickListener(button_Commodity06_Name_click);
        textView_Commodity01_Price = getView().findViewById(R.id.textView_Commodity01_Price);
        textView_Commodity02_Price = getView().findViewById(R.id.textView_Commodity02_Price);
        textView_Commodity03_Price = getView().findViewById(R.id.textView_Commodity03_Price);
        textView_Commodity04_Price = getView().findViewById(R.id.textView_Commodity04_Price);
        textView_Commodity05_Price = getView().findViewById(R.id.textView_Commodity05_Price);
        textView_Commodity06_Price = getView().findViewById(R.id.textView_Commodity06_Price);
    }

    Button button_Commodity01_Name;
    Button button_Commodity02_Name;
    Button button_Commodity03_Name;
    Button button_Commodity04_Name;
    Button button_Commodity05_Name;
    Button button_Commodity06_Name;
    TextView textView_Commodity01_Price;
    TextView textView_Commodity02_Price;
    TextView textView_Commodity03_Price;
    TextView textView_Commodity04_Price;
    TextView textView_Commodity05_Price;
    TextView textView_Commodity06_Price;

    private POS_Factory pos_factory;
    private AmountFragment amountFragment;
    private SharedPreferences sharedPreferences;
    private ActivityMain activityMain;
}
