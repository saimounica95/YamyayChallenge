package com.example.vishnusai.yamyaycodingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalProductPage extends AppCompatActivity {
    TextView product;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product_page);
        product = (TextView)findViewById(R.id.finalProduct);

        product.setText(getIntent().getExtras().getString("productName"));

        checkout =(Button)findViewById(R.id.checkout);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(finalProductPage.this, checkoutPage.class);
                startActivity(i);
            }
        });


    }
}
