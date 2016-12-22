package com.example.tonghung.sqlitedemo2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tonghung.sqlitedemo2.database.DatabaseHelper;
import com.example.tonghung.sqlitedemo2.object.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinType;
    private EditText etTitle, etDesc, etPrice;
    private Button btnAdd, btnCoffee, btnDrink, btnFood;
    private TextView tvResult;
    private String itemType;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinType = (Spinner) findViewById(R.id.spinnerType);
        etTitle = (EditText) findViewById(R.id.editTextTitle);
        etDesc = (EditText) findViewById(R.id.editTextDesc);
        etPrice = (EditText) findViewById(R.id.editTextPrice);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnCoffee = (Button) findViewById(R.id.buttonCoffee);
        btnDrink = (Button) findViewById(R.id.buttonDrink);
        btnFood = (Button) findViewById(R.id.buttonFood);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        loadSpinnerType();
        getItemType();

        btnAdd.setOnClickListener(this);
        btnCoffee.setOnClickListener(this);
        btnDrink.setOnClickListener(this);
        btnFood.setOnClickListener(this);

    }

    private void loadSpinnerType(){
        String[] arrType = new String[]{"Coffee", "Drink", "Food"};
        spinType.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrType));
    }

    private void getItemType(){
        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        itemType = "Coffee";
                        break;
                    case 1:
                        itemType = "Drink";
                        break;
                    case 2:
                        itemType = "Food";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdd){
            if(db.insertItem(new Item(itemType, etTitle.getText().toString(), etDesc.getText()
                    .toString(), Integer.parseInt(etPrice.getText().toString()))) != 0){
                Toast.makeText(MainActivity.this, "insert successful", Toast.LENGTH_SHORT)
                        .show();
            }else{
                Toast.makeText(MainActivity.this, "insert failure", Toast.LENGTH_SHORT).show();
            }
        }else if(v == btnCoffee){
            Cursor c = db.selectItem("Coffee");
            List<Item> listItem = new ArrayList<>();
            while(c.moveToNext()){
                listItem.add(new Item(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)
                        , c.getInt(4)));
            }

            tvResult.setText(listItem.toString());
        }else if(v == btnDrink){
            Cursor c = db.selectItem("Drink");
            List<Item> listItem = new ArrayList<>();
            while(c.moveToNext()){
                listItem.add(new Item(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)
                        , c.getInt(4)));
            }

            tvResult.setText(listItem.toString());
        }else if(v == btnFood){
            Cursor c = db.selectItem("Food");
            List<Item> listItem = new ArrayList<>();
            while(c.moveToNext()){
                listItem.add(new Item(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)
                        , c.getInt(4)));
            }

            tvResult.setText(listItem.toString());
        }
    }
}
