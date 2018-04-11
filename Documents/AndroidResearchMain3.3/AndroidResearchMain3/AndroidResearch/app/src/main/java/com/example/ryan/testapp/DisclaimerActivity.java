package com.example.ryan.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class DisclaimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        final Button btn =(Button)findViewById( R.id.mybutton);
        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {

                    btn.setVisibility(View.VISIBLE);
                    checkBox.setVisibility(View.INVISIBLE);

                } else if(!checkBox.isChecked()) {

                    btn.setVisibility(View.GONE);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navigateHome = new Intent(DisclaimerActivity.this, MainActivity.class);
                startActivity(navigateHome);
            }
        });
    }
}
