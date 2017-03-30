package com.example.vishnusai.yamyaycodingtest;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Vishnu Sai on 03/28/2017.
 */

public class productList extends ArrayAdapter<product>{

    private Activity context;
    private List<product> productList;
    private FirebaseDatabase mFireBaseDatabase;
    private DatabaseReference myRef;


    public productList(Activity context, List<product> productList){

        super(context,R.layout.list_layout, productList);
        this.context = context;
        this.productList = productList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewItem);

        product prod = productList.get(position);
        textViewName.setText(prod.getpname());
        return listViewItem;
    }
}
