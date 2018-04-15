package com.example.sue.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

public class Calc extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final Button btn0 = (Button) findViewById(R.id.btn0);
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);
        final Button btn8 = (Button) findViewById(R.id.btn8);
        final Button btn9 = (Button) findViewById(R.id.btn9);
        final Button btn_plus = (Button) findViewById(R.id.btn_plus);
        final Button btn_sub = (Button) findViewById(R.id.btn_sub);
        final Button btn_multi = (Button) findViewById(R.id.btn_multi);
        final Button btn_div = (Button) findViewById(R.id.btn_div);
        final Button btn_equal = (Button) findViewById(R.id.btn_equal);

        final TextView textView = (TextView) findViewById(R.id.textView);

        final Map <String, String> calc = new HashMap <String, String>();
        calc.put("reset", "N");

        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ((Button) v).getText(), Toast.LENGTH_SHORT).show();

                String text = "";
                //숫자라면 Input
                if (!((Button) v).getText().equals("+") && !((Button) v).getText().equals("-") && !((Button) v).getText().equals("*") && !((Button) v).getText().equals("/")) {
                    if (calc.get("reset").equals("Y")) {
                        calc.put("reset", "N");
                        calc.put("number1", "");
                        calc.put("operation", "");

                        text = (String) ((Button) v).getText();
                        textView.setText(Integer.parseInt(text) + "");
                    } else {
                        text = (String) textView.getText();
                        text += ((Button) v).getText();

                        textView.setText(Integer.parseInt(text) + "");
                    }
                }

                // 연산자라면 연산자와 이전에 입력한 숫자 Input
                int number1;
                int number2;
                int result;

                if (((Button) v).getText().equals("+") || ((Button) v).getText().equals("-") || ((Button) v).getText().equals("*") || ((Button) v).getText().equals("/")) {
                    calc.put("operation", (String) ((Button) v).getText());
                    calc.put("number1", (String) textView.getText());
                    textView.setText(" 0 ");
                }
                // 이퀄 時 연산

                if (((Button) v).getText().equals("=")) {
                    number1 = Integer.parseInt(calc.get("number1"));
                    number2 = Integer.parseInt(calc.get("number2"));

                    result = 0;


                    if (calc.get("operation").equals("+")) {
                        result = number1 + number2;
                    } else if (calc.get("operation").equals("-")) {
                        result = number1 - number2;
                    } else if (calc.get("operation").equals("*")) {
                        result = number1 * number2;
                    } else if (calc.get("operation").equals("/")) {
                        double divResult = number1 / number2;
                        result = (int) divResult;
                    }

                    // 리셋 값 (결과 時)
                    calc.put("reset", "Y");

                    textView.setText(result + "");
                }
            }
        };
        btn0.setOnClickListener(clickListener);
        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        btn3.setOnClickListener(clickListener);
        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
        btn8.setOnClickListener(clickListener);
        btn9.setOnClickListener(clickListener);
        btn_plus.setOnClickListener(clickListener);
        btn_sub.setOnClickListener(clickListener);
        btn_multi.setOnClickListener(clickListener);
        btn_div.setOnClickListener(clickListener);
        btn_equal.setOnClickListener(clickListener);
    }
}
