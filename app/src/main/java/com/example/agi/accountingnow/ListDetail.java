package com.example.agi.accountingnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListDetail extends AppCompatActivity {

    //private TextView txt_Item, txt_Date, txt_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        final TextView txt_Item = (TextView) findViewById(R.id.txtTitle);
        final TextView txt_Date = (TextView) findViewById(R.id.txtDate);
        final TextView txt_Price = (TextView) findViewById(R.id.txtPrice);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        String itemExtra = extras.getString("EXTRA_ITEM");
        String dateExtra = extras.getString("EXTRA_DATE");
        String priceExtra = extras.getString("EXTRA_PRICE");

        txt_Item.setText(itemExtra);
        txt_Date.setText(dateExtra);
        txt_Price.setText(priceExtra);

    }
}
