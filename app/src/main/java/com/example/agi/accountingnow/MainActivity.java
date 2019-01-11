package com.example.agi.accountingnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //var for recyclerView
    private ArrayList<String> mDateHolder = new ArrayList<>();
    private ArrayList<String> mItemHolder = new ArrayList<>();
    private ArrayList<String> mPriceHolder = new ArrayList<>();
    private ArrayList<String> mDescHolder = new ArrayList<>();

    //var for adding to recyclerView
    String tDateHolder, tItemHolder, tPriceHolder, tDescHolder;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started.");

        initTransactionListDemo();
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivityForResult(new Intent(getApplicationContext(), InputActivity.class), 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 999 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            assert extras != null;
            tDateHolder = extras.getString("EXTRA_DATE");
            tItemHolder = extras.getString("EXTRA_ITEM");
            tPriceHolder = extras.getString("EXTRA_PRICE");
            tDescHolder = extras.getString("EXTRA_DESC");

            initTransactionList();
        }
    }

    private void initTransactionList(){
        mItemHolder.add(tItemHolder);
        mDateHolder.add(tDateHolder);
        mPriceHolder.add("Rp" + tPriceHolder);
        mDescHolder.add(tDescHolder);

        initRecyclerView();
    }

    private void initTransactionListDemo(){
        mItemHolder.add("Bahan baku makanan");
        mDateHolder.add("11/11/2019");
        mPriceHolder.add("Rp1500000");
        mDescHolder.add("This is a test description. Lorem ipsum sir color amet.");

        mItemHolder.add("Piring kertas");
        mDateHolder.add("12/11/2019");
        mPriceHolder.add("Rp300000");
        mDescHolder.add("This is a test description. Lorem ipsum sir color amet.");

        mItemHolder.add("Gelas kertas");
        mDateHolder.add("13/11/2019");
        mPriceHolder.add("Rp300000");
        mDescHolder.add("This is a test description. Lorem ipsum sir color amet.");

        mItemHolder.add("Minyak goreng");
        mDateHolder.add("14/11/2019");
        mPriceHolder.add("Rp70000");
        mDescHolder.add("This is a test description. Lorem ipsum sir color amet.");

        mItemHolder.add("Sambal Balado");
        mDateHolder.add("11/11/2019");
        mPriceHolder.add("Rp150000");
        mDescHolder.add("This is a test description. Lorem ipsum sir color amet.");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mDateHolder, mItemHolder, mPriceHolder, mDescHolder);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
