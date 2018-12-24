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


/**
 * A simple {@link Fragment} subclass.
 */
public class AmountFragment extends Fragment {

    public interface CallbackInterface{
        public void Set_commodity_name();
    }

//    public void Set_commodity_name(String commodity_name){
//        editText_select_commodity_name.setText(commodity_name);
//    }
//
//    public void Set_commodity_name(){
//        try{
//            test = "123";
//            editText_select_commodity_name.setText("123");
//        }catch (Exception e){
//            Log.d("kkk2",e.getMessage());
//            Log.d("kkk2",getViewLifecycleOwner().toString());
//        }
//
//    }

    public void Set_commodity_price(String commodity_price){
        editText_select_commodity_name.setText(commodity_price);
    }

    public void Set_commodity_quantity(String commodity_quantity){
        editText_select_commodity_name.setText(commodity_quantity);
    }

    private View.OnClickListener button_00_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                editText_select_commodity_quantity.setText("0");
            }catch (Exception e){
                Log.d("kkk3",e.getMessage());
            }
        }
    };

    private View.OnClickListener button_01_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                editText_select_commodity_quantity.setText("1");
            }catch (Exception e){
                Log.d("kkk3",e.getMessage());
            }
        }
    };

    private View.OnClickListener button_02_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_03_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_04_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_05_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_06_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_07_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_08_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_09_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_500_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_1000_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_Query_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_Amount_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_Correction_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_Delete_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener button_Confirm_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public AmountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedPreferences = ((ActivityMain)getActivity()).Get_SharedPreferences();
        InitialComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false);
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
        InitialComponent();
        editText_select_commodity_name.setText(test);
    }

    private void InitialComponent() {
        editText_select_commodity_name= getView().findViewById(R.id.editText_select_commodity_name);
        editText_select_commodity_price= getView().findViewById(R.id.editText_select_commodity_price);
        editText_select_commodity_quantity= getView().findViewById(R.id.editText_select_commodity_quantity);
        button_00 = getView().findViewById(R.id.button_00);
        button_00.setOnClickListener(button_00_click);
        button_01 = getView().findViewById(R.id.button_01);
        button_01.setOnClickListener(button_01_click);
        button_02 = getView().findViewById(R.id.button_02);
        button_02.setOnClickListener(button_02_click);
        button_03 = getView().findViewById(R.id.button_03);
        button_03.setOnClickListener(button_03_click);
        button_04 = getView().findViewById(R.id.button_04);
        button_04.setOnClickListener(button_04_click);
        button_05 = getView().findViewById(R.id.button_05);
        button_05.setOnClickListener(button_05_click);
        button_06 = getView().findViewById(R.id.button_06);
        button_06.setOnClickListener(button_06_click);
        button_07 = getView().findViewById(R.id.button_07);
        button_07.setOnClickListener(button_07_click);
        button_08 = getView().findViewById(R.id.button_08);
        button_08.setOnClickListener(button_08_click);
        button_09 = getView().findViewById(R.id.button_09);
        button_09.setOnClickListener(button_09_click);
        button_500 = getView().findViewById(R.id.button_500);
        button_500.setOnClickListener(button_500_click);
        button_1000 = getView().findViewById(R.id.button_1000);
        button_1000.setOnClickListener(button_1000_click);
        button_Query = getView().findViewById(R.id.button_Query);
        button_Query.setOnClickListener(button_Query_click);
        button_Amount = getView().findViewById(R.id.button_Amount);
        button_Amount.setOnClickListener(button_Amount_click);
        button_Correction = getView().findViewById(R.id.button_Correction);
        button_Correction.setOnClickListener(button_Correction_click);
        button_Delete = getView().findViewById(R.id.button_Delete);
        button_Delete.setOnClickListener(button_Delete_click);
        button_Confirm = getView().findViewById(R.id.button_Confirm);
        button_Confirm.setOnClickListener(button_Confirm_click);
    }

    EditText editText_select_commodity_name;
    EditText editText_select_commodity_price;
    EditText editText_select_commodity_quantity;
    Button button_00;
    Button button_01;
    Button button_02;
    Button button_03;
    Button button_04;
    Button button_05;
    Button button_06;
    Button button_07;
    Button button_08;
    Button button_09;
    Button button_500;
    Button button_1000;
    Button button_Query;
    Button button_Amount;
    Button button_Correction;
    Button button_Delete;
    Button button_Confirm;

    private SharedPreferences sharedPreferences;
    private POS_Factory pos_factory;
    private ActivityMain activityMain;

    private String test = "test";
}
