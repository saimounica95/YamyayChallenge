package com.example.vishnusai.yamyaycodingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class finalProductPage extends AppCompatActivity {
    TextView product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product_page);
        product = (TextView)findViewById(R.id.finalProduct);

        product.setText(getIntent().getExtras().getString("productName"));

    }
}
