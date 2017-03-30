package com.example.vishnusai.yamyaycodingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    EditText searchText;
    Button search;
    ListView listViewProducts;
    DatabaseReference databaseList;
    List<product> productListArray;
    private FirebaseDatabase mFireBaseDatabase;
    private DatabaseReference myRef;
    List<String> sample;
    //final String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseList = FirebaseDatabase.getInstance().getReference().child("products");
        listViewProducts = (ListView)findViewById(R.id.listViewProducts);
        productListArray = new ArrayList<>();
        mFireBaseDatabase = FirebaseDatabase.getInstance();
        searchText = (EditText)findViewById(R.id.productEntry);
        search = (Button)findViewById(R.id.searchList);
        myRef = mFireBaseDatabase.getReference();

        search.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                displayItems(searchText.getText().toString());
            }
        });



    }

    @Override
    protected void onStart() {

        super.onStart();


        //displayItems();
    }
    private void displayItems(String s){
        final String Search = s;
        databaseList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productListArray.clear();

                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    //Log.v(databaseList.toString(),"Hiiiiiiiiiiiiiii");
                    product p = productSnapshot.getValue(product.class);

                    if((p.pname).contains(""+Search))
                    productListArray.add(p);
                }
                //Log.v(productListArray.toString(),"before adapter List array "+productListArray.toString());

                productList adapter = new productList(Main2Activity.this, productListArray);
                //Log.v(productListArray.toString(),"after adapter List array "+productListArray.toString());
                //Log.v(String.valueOf(adapter),"after adapter List array "+String.valueOf(adapter));
                listViewProducts.setAdapter(adapter);

                listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int itemposition = position;
                        //Log.v(databaseList.toString(),"Hiiiiiiiiiiiiiii "+itemposition);
                        product value = (product) listViewProducts.getItemAtPosition(position);
                        String sample = value.pname.toString();
                        //Log.v(databaseList.toString(),sample);
                        Toast.makeText(Main2Activity.this, ""+value.pname, Toast.LENGTH_SHORT).show();
                        Intent productFinalPage = new Intent(Main2Activity.this, finalProductPage.class);
                        productFinalPage.putExtra("productName",sample);
                        startActivity(productFinalPage);

                    }
                });
                //Log.v(productListArray.toString(),"after setting adapter List array "+productListArray.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
