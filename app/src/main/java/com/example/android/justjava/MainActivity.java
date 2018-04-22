/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int numberofCoffes=0;
    int coffeePricePerCup=5;


    public void submitOrder(View view) {

        CheckBox whppedCreamCB = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWC = whppedCreamCB.isChecked();

        CheckBox ChocolateCB = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChoco = ChocolateCB.isChecked();

        EditText editText_Name = (EditText) findViewById(R.id.text_name);
        String name = editText_Name.getText().toString();




        //String total=Integer.toString(numberofCoffes*(coffeePricePerCup+whippedCramCost+chocolateCost));
        int price=calculatePrice(hasWC,hasChoco);
        String message= createOrderSummary(price,hasWC,hasChoco,name);
        displayMessage(message);

    }


    public void increment(View view) {

        if (numberofCoffes != 100)
        numberofCoffes=numberofCoffes+1;
        display(numberofCoffes);
    }



    public void decrement(View view) {

        if (numberofCoffes != 1)
        numberofCoffes=numberofCoffes-1;
        display(numberofCoffes);

    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price on the screen.
     */
   // private void displayPrice(String number) {
     //   TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
    //    priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
  //  }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaaryTextView.setText(message);
    }

    private int calculatePrice(Boolean hasWC,Boolean hasChoco) {

        int whippedCramCost=0;
        int chocolateCost=0;


        if(hasWC==true)
        {

            whippedCramCost=1;

        }

        if(hasChoco==true)
        {

            chocolateCost=2;

        }

        return  numberofCoffes*(coffeePricePerCup+whippedCramCost+chocolateCost);

    }

    private String createOrderSummary(int price,boolean hasWC,boolean hasChoco,String name) {

        return "Name: "+name+"\n"+
                "Add whipped cream ? "+hasWC+"\n"+
                "Add chocolate ? "+hasChoco+"\n"+
                "Quantity: "+numberofCoffes+"\n"+
                "Total "+price+"\n"+
                "Thank You !"
        ;

    }



}