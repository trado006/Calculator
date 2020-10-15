package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import static com.example.calculator.R.id.numberview;

public class MainActivity extends AppCompatActivity {
    TextView mytextview;
    xuLi xuli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytextview = findViewById(numberview);
        xuli = new xuLi();
        findViewById(R.id.mot_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            xuli.appendN(1,mytextview);
            }
        });
        findViewById(R.id.hai_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(2,mytextview);
            }
        });
        findViewById(R.id.ba_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(3,mytextview);
            }
        });
        findViewById(R.id.bon_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(4,mytextview);
            }
        });
        findViewById(R.id.nam_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(5,mytextview);
            }
        });
        findViewById(R.id.sau_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(6,mytextview);
            }
        });
        findViewById(R.id.bay_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(7,mytextview);
            }
        });
        findViewById(R.id.tam_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(8,mytextview);
            }
        });
        findViewById(R.id.chin_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendN(9,mytextview);
            }
        });
        findViewById(R.id.khong_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendZero(mytextview);
            }
        });
        findViewById(R.id.chia_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            xuli.appendDau('/',mytextview);
            }
        });
        findViewById(R.id.nhan_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendDau('*',mytextview);
            }
        });
        findViewById(R.id.cong_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendDau('+',mytextview);
            }
        });
        findViewById(R.id.tru_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.appendDau('-',mytextview);
            }
        });
        findViewById(R.id.ce_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.ce(mytextview);
            }
        });
        findViewById(R.id.c_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.c(mytextview);
            }
        });
        findViewById(R.id.bs_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.bs(mytextview);
            }
        });
        findViewById(R.id.bang_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.bang(mytextview);
            }
        });
        findViewById(R.id.cham_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.cham(mytextview);
            }
        });
        findViewById(R.id.doi_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli.DoiSo(mytextview);
            }
        });

    }
}
