package com.example.learnintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etItemQty = findViewById(R.id.et_item_qty);
        Button moveNewPage = findViewById(R.id.to_new_page);

        moveNewPage.setOnClickListener(view -> {
            Intent toNewPage = new Intent(MainActivity.this, CheckoutActivity.class);

            if (etItemQty.getText().length() > 0) {
                int itemQty = Integer.parseInt(etItemQty.getText().toString());
                if (itemQty <= 0) {
                    Toast.makeText(MainActivity.this, "Items must not be 0 or less", Toast.LENGTH_SHORT).show();
                } else {
                    toNewPage.putExtra("itemQty", Integer.toString(itemQty));
                    startActivity(toNewPage);
                }
            } else {
                Toast.makeText(MainActivity.this, "Please enter items quantity", Toast.LENGTH_SHORT).show();
            }

        });
    }
}