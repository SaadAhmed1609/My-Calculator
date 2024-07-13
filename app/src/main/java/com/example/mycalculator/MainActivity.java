package com.example.mycalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    double firstNum;
    String operation;
    //Change 1

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.number0);
        Button num1 = findViewById(R.id.number1);
        Button num2 = findViewById(R.id.number2);
        Button num3 = findViewById(R.id.number3);
        Button num4 = findViewById(R.id.number4);
        Button num5 = findViewById(R.id.number5);
        Button num6 = findViewById(R.id.number6);
        Button num7 = findViewById(R.id.number7);
        Button num8 = findViewById(R.id.number8);
        Button num9 = findViewById(R.id.number9);

        Button onn = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.multiply);
        Button sub = findViewById(R.id.subtract);
        Button add = findViewById(R.id.add);
        Button equals = findViewById(R.id.equals);
        Button dot = findViewById(R.id.point);
        Button zero = findViewById(R.id.number0);
        Button del= findViewById(R.id.del);

        TextView screen = findViewById(R.id.screen);
        ac.setOnClickListener(view ->{
            firstNum =0;
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(TextView.GONE));
        onn.setOnClickListener(view -> {
            screen.setVisibility(TextView.VISIBLE);
            screen.setText("0");
        });

        ArrayList<Button> num = new ArrayList<>();
        num.add(num0);
        num.add(num1);
        num.add(num2);
        num.add(num3);
        num.add(num4);
        num.add(num5);
        num.add(num6);
        num.add(num7);
        num.add(num8);
        num.add(num9);

        for (Button b : num) {
            b.setOnClickListener(view ->{
                if(!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }
                else{
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(add);
        opers.add(sub);
        opers.add(div);
        opers.add(mul);
        for(Button b : opers)
        {
            b.setOnClickListener(view ->
            {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        del.setOnClickListener(view ->{
            String number = screen.getText().toString();
            if(number.length()>1)
            {
                screen.setText(number.substring(0, number.length()-1));
            }
            else if (number.length() == 1 && !number.equals("0"))
            {
                screen.setText("0");
            }
        });

        dot.setOnClickListener(view ->{
            if(!screen.getText().toString().contains("."))
            {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        equals.setOnClickListener( view ->{
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch(operation)
            {
                case "/" :
                    result = firstNum/secondNum;
                    break;

                case "x" :
                    result = firstNum*secondNum;
                    break;

                case "+" :
                    result = firstNum+secondNum;
                    break;

                case "-" :
                    result = firstNum-secondNum;
                    break;

                default:
                    result = firstNum+secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });
    }

}