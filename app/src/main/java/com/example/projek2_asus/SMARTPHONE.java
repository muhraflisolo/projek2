package com.example.projek2_asus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SMARTPHONE extends AppCompatActivity {

    TextView Stock1, Stock2, Stock3, Stock4;
    String countStock;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projek2-5acb9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);

        Stock1 = findViewById(R.id.tvStock1);
        Stock2 = findViewById(R.id.tvStock2);
        Stock3 = findViewById(R.id.tvStock3);
        Stock4 = findViewById(R.id.tvStock4);

        pvStock();

    }

    public void pvStock () {
        databaseReference.child("product").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("S001")) {
                    countStock = snapshot.child("S001").child("stock").getValue(String.class);
                    Stock1.setText("STOCK: "+countStock);
                }

                if (snapshot.hasChild("S002")) {
                    countStock = snapshot.child("S002").child("stock").getValue(String.class);
                    Stock2.setText("STOCK: "+countStock);
                }

                if (snapshot.hasChild("S003")) {
                    countStock = snapshot.child("S003").child("stock").getValue(String.class);
                    Stock3.setText("STOCK: "+countStock);
                }

                if (snapshot.hasChild("S004")) {
                    countStock = snapshot.child("S004").child("stock").getValue(String.class);
                    Stock4.setText("STOCK: "+countStock);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}