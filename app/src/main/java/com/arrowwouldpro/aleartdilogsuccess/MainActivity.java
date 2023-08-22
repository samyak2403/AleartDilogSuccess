package com.arrowwouldpro.aleartdilogsuccess;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button successButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        successButton = findViewById(R.id.successButoon);

        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showSuccessDialog();
            }
        });
    }

    private void showSuccessDialog() {
        ConstraintLayout successConstraintLayout = findViewById(R.id.successContrainLayout);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.success_dialog,successConstraintLayout);
        Button successDone = view.findViewById(R.id.successDone);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        successDone.findViewById(R.id.successDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();

            }
        });
        if (alertDialog.getWindow() != null){

            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            alertDialog.show();

        }
    }
}