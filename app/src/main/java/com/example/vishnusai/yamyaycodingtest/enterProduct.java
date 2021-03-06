package com.example.vishnusai.yamyaycodingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class enterProduct extends AppCompatActivity {


    EditText productEntry;
    Button saveProduct;
    DatabaseReference databaseProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_product);
        productEntry = (EditText) findViewById(R.id.productEntry);
        saveProduct = (Button) findViewById(R.id.saveProduct);
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");

        saveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addProduct();
            }
        });
    }

    private void addProduct(){
        String productName = productEntry.getText().toString().trim();
        if(!TextUtils.isEmpty(productName)){
            String id = databaseProducts.push().getKey();
            product prod = new product(id, productName);

            databaseProducts.child(id).setValue(prod);

            Toast.makeText(this, "Product added successfull to firebase", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "please enter a product",Toast.LENGTH_LONG).show();
        }
    }


}
