package com.example.calcconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private Button[] bttns;
    private Button[] actns;
    private TextView Big;
    private TextView Small;
    private double num1 = -1;
    private double num2 = 0;
    private int temp = 0;
    private int i;
    private String s;
    private boolean bool;
    private char Action = 'Z';

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        for(i=0;i<bttns.length;i++) {
            bttns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(i=0;i<bttns.length;i++){
                        if(v.getId()==bttns[i].getId()) {
                            if(i!=10) {
                                if (Action == '=') {
                                    Big.setText("" + i);
                                    Action = 'Z';
                                } else
                                    Big.setText(Big.getText().toString() + i);
                            }
                            else{
                                if (Action == '=') {
                                    Big.setText("0.");
                                    Action = 'Z';
                                } else {
                                    if(Big.getText()==null||Big.getText()=="")
                                        Big.setText("0.");
                                    else{
                                        String tx = (String) Big.getText();
                                        boolean be = false;
                                        for(int k=0;k<tx.length();k++)
                                            if(tx.charAt(k)=='.')
                                                be = true;
                                        if(!be)
                                            Big.setText(Big.getText()+".");
                                    }

                                }
                            }
                        }
                    }

                }
            });
        }

        for(i=0;i<actns.length;i++) {
            actns[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(v.getId()!=actns[4].getId()&&v.getId()!=actns[5].getId()&&v.getId()!=actns[6
                            ].getId()) {
                        for (int j = 0; j < actns.length - 2; j++) {
                            if (actns[j].getId() == v.getId()) {
                                if (Small.getText() == null || (Small.getText() == "")) {
                                    if ((Big.getText() == null)||(Big.getText()==""))
                                        num1 = 0;
                                    else
                                        num1 = Double.parseDouble("" + Big.getText());

                                } else {
                                    if ((Big.getText() == null)||(Big.getText()==""))
                                        num2 = 0;
                                    else
                                        num2 = Double.parseDouble("" + Big.getText());

                                    switch (Action) {
                                        case '+':
                                            num1 = num1 + num2;
                                            break;
                                        case '-':
                                            num1 = num1 - num2;
                                            break;
                                        case '/':
                                            if(num2!=0)
                                                num1 = num1 / num2;
                                            break;
                                        case '*':
                                            num1 = num1 * num2;
                                            break;
                                        default:
                                            break;
                                    }
                                }

                                temp = (int)num1;
                                bool = num1 == (double) temp;
                                s = num1+"";

                                if(!bool)
                                    if(s.length()>8) {
                                        s = s.substring(0,7);
                                        num1 = Double.parseDouble(s);
                                    }

                                switch (j) {
                                    case 0:
                                        Small.setText(bool?temp+" +":num1+" +");
                                        Action = '+';
                                        break;
                                    case 1:
                                        Small.setText(bool?temp+" -":num1 + " -");
                                        Action = '-';
                                        break;
                                    case 2:
                                        Small.setText(bool?temp+" /":num1 + " /");
                                        Action = '/';
                                        break;
                                    case 3:
                                        Small.setText(bool?temp+" *":num1 + " *");
                                        Action = '*';
                                        break;
                                    default:
                                        break;
                                }
                                Big.setText(null);
                            }
                        }
                    }
                    else {
                        if(v.getId()==actns[4].getId()) {
                            if ((Small.getText() == null) || Small.getText() == "") ;
                            else {
                                if ((Big.getText() == null) || (Big.getText() == ""))
                                    num2 = 0;
                                else
                                    num2 = Double.parseDouble("" + Big.getText());

                                switch (Action) {
                                    case '+':
                                        num1 = num1 + num2;
                                        break;
                                    case '-':
                                        num1 = num1 - num2;
                                        break;
                                    case '/':
                                        if (num2 != 0)
                                            num1 = num1 / num2;
                                        break;
                                    case '*':
                                        num1 = num1 * num2;
                                        break;
                                    default:
                                        break;
                                }

                                temp = (int) num1;
                                bool = num1 == (double) temp;
                                s = num1 + "";

                                if (!bool)
                                    if (s.length() > 8) {
                                        s = s.substring(0, 7);
                                        num1 = Double.parseDouble(s);
                                    }

                                Small.setText(null);
                                Big.setText(bool ? temp + "" : num1 + "");

                                Action = '=';
                            }
                        }
                        if(v.getId()==actns[5].getId()) {
                            if ((Big.getText() == null)||(Big.getText()==""));
                            else{
                                String C = (String)Big.getText();
                                Big.setText(C.substring(0,C.length()-1));
                                if(C.length()==1)
                                    Big.setText(null);
                            }
                        }
                        if(v.getId()==actns[6].getId()) {
                            if ((Big.getText() == null)||(Big.getText()==""));
                            else{
                                Big.setText(null);
                                Small.setText(null);
                                Action = 'Z';
                            }
                        }
                    }
                }
            });
        }
    }

    public void setupUIViews() {
        bttns = new Button[11];
        bttns[0] = (Button)findViewById(R.id.btn0);
        bttns[1] = (Button)findViewById(R.id.btn1);
        bttns[2] = (Button)findViewById(R.id.btn2);
        bttns[3] = (Button)findViewById(R.id.btn3);
        bttns[4] = (Button)findViewById(R.id.btn4);
        bttns[5] = (Button)findViewById(R.id.btn5);
        bttns[6] = (Button)findViewById(R.id.btn6);
        bttns[7] = (Button)findViewById(R.id.btn7);
        bttns[8] = (Button)findViewById(R.id.btn8);
        bttns[9] = (Button)findViewById(R.id.btn9);
        bttns[10] = (Button)findViewById(R.id.btnDec);

        actns = new Button[7];
        actns[0] = (Button)findViewById(R.id.btnPlus);
        actns[1] = (Button)findViewById(R.id.btnMinus);
        actns[2] = (Button)findViewById(R.id.btnDiv);
        actns[3] = (Button)findViewById(R.id.btnMul);
        actns[4] = (Button)findViewById(R.id.btnEqual);
        actns[5] = (Button)findViewById(R.id.btnC);
        actns[6] = (Button)findViewById(R.id.btnAC);

        Big = (TextView)findViewById(R.id.tabBig);
        Small = (TextView)findViewById(R.id.tabSmall);
        Small.setText(null);
        Big.setText(null);
    }
}
