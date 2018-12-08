package com.example.mayank.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int in=-1,out=-1;
    double y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rupee = (Button)findViewById(R.id.rupee);
        Button dollar = (Button)findViewById(R.id.dollar);
        Button pound = (Button)findViewById((R.id.pound));
        Button euro = (Button)findViewById(R.id.euro);
        EditText amt=(EditText)findViewById(R.id.amt);
        Button equalto = (Button)findViewById(R.id.equalto);
        final TextView output = (TextView)findViewById(R.id.output);

        rupee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in==-1)
                {
                    in=1;
                }
                else
                    out=1;

            }
        });
        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in==-1)
                    in=2;
                else
                    out=2;

            }
        });
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in==-1)
                    in=3;
                else
                    out=3;
            }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in==-1)
                    in=4;
                else
                    out=4;

            }
        });

        // Value of is used to get integer value out of a string
        // For example "12" is a string. Integer.valueOf("12") will give me 12.
        // This 12 is an integer now.
        // So i can use it as a number.

        final int x = Integer.valueOf(amt.getText().toString());

        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (in != -1 && out != -1) {
                    y = calc(in, out, x);
                    output.setText("The output is "+y);
                }
                else
                    Toast.makeText(getApplicationContext(), "please enter currencies again",Toast.LENGTH_LONG).show();
            }

        });



    }

    static double calc(int in,int out, int x)
    {
    double y = -1;

        if(in==1)
        {
            if(out==2) {
                y = (x * 0.014);
                return y;
            }
            else if(out==3){
                y=x * 0.011;
                return y;
            }
            else if(out==4){
                y=x*0.012;
                return y;
            }
        }
        else if(in==2)
        {
            if(out==1)
            {
                y=x*71.38;
                return y;
            }
            else if(out==3)
            {
                y=x*0.79;
                return y;
            }
            else if(out==4)
            {
                y=x*0.88;
                return y;
            }
        }
        else if(in==3)
        {
            if (out == 1)
            {
                y=x*90.87;
                return y;
            }
            else if(out==2)
            {
                y=x*1.27;
                return y;
            }
            else if(out==4)
            {
                y=x+1.12;
                return y;
            }
        }
        else if(in==4)
        {
            if(out==1)
            {
                y=x*81.24;
                return y;
            }
            else if(out==2)
            {
                y=x*1.14;
                return y;
            }
            else if(out==3)
            {
                y=x*0.89;
                return y;
            }
        }
        return y;
    }
}
