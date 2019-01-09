package com.example.agi.accountingnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private EditText edt_Item;
    private EditText edt_Date;
    private EditText edt_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edt_Item = (EditText) findViewById(R.id.edtItem);
        edt_Date = (EditText) findViewById(R.id.edtDate);
        edt_Price = (EditText) findViewById(R.id.edtPrice);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        Bundle extras = new Bundle();
        extras.putString("EXTRA_ITEM", edt_Item.getText().toString());
        extras.putString("EXTRA_DATE", edt_Date.getText().toString());
        extras.putString("EXTRA_PRICE", edt_Price.getText().toString());
        i.putExtras(extras);
        setResult(RESULT_OK, i);
        finish();
    }
}
