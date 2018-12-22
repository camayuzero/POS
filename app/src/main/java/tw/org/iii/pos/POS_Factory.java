package tw.org.iii.pos;

import android.widget.EditText;

public class POS_Factory{

    public final String KEY_drink = "KEY_drink";
    public final String KEY_drink_name = "KEY_drink_name";
    public final String KEY_drink_price = "KEY_drink_price";
    public final String KEY_drink_quantity = "KEY_drink_quantity";
    public final String KEY_drink_total_amount = "KEY_drink_total_amount";
    public final String KEY_drink_pay = "KEY_drink_pay";
    public final String KEY_drink_change = "KEY_drink_change";

    private String drink_name;  //飲料名稱
    private String drink_price; //飲料單價
    private String drink_quantity;  //飲料數量
    private String drink_total_amount;  //總金額
    private String drink_pay;  //付款
    private String drink_change;  //找回


    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public String getDrink_price() {
        return drink_price;
    }

    public void setDrink_price(String drink_price) {
        this.drink_price = drink_price;
    }

    public String getDrink_quantity() {
        return drink_quantity;
    }

    public void setDrink_quantity(String drink_quantity) {
        this.drink_quantity = drink_quantity;
    }

    public String getDrink_total_amount() {
        return drink_total_amount;
    }

    public void setDrink_total_amount(String drink_total_amount) {
        this.drink_total_amount = drink_total_amount;
    }

    public String getDrink_pay() {
        return drink_pay;
    }

    public void setDrink_pay(String drink_pay) {
        this.drink_pay = drink_pay;
    }

    public String getDrink_change() {
        return drink_change;
    }

    public void setDrink_change(String drink_change) {
        this.drink_change = drink_change;
    }

}
