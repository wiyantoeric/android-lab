package com.example.learnintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {
    private void backToMainActivity() {
        Intent backToMainActivity = new Intent(this, MainActivity.class);
        backToMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(backToMainActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        Button btnConfirm = findViewById(R.id.btn_confirm);
        Button btnCancel = findViewById(R.id.btn_cancel);

        String itemQty = intent.getStringExtra("itemQty");
        int itemPrice = 12000;

        TextView tvItemQty = findViewById(R.id.tv_item_qty);
        TextView tvItemPrice = findViewById(R.id.tv_item_price);
        TextView tvSubtotal = findViewById(R.id.tv_subtotal);

        if (itemQty != null) {
            tvItemQty.setText(itemQty);
            tvItemPrice.setText("Rp. " + itemPrice);
            tvSubtotal.setText("Rp. " + Integer.valueOf(itemQty) * itemPrice);
        } else {
            backToMainActivity();
        }

        btnCancel.setOnClickListener(view -> {
            backToMainActivity();
        });

        btnConfirm.setOnClickListener(view -> {
            Toast.makeText(this, "Checkout Successful", Toast.LENGTH_SHORT).show();
            backToMainActivity();
        });
    }
}