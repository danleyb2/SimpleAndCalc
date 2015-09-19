package com.ndieksdroid.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{

    Button  one,two,three,
            four,five,six,
            seven,eight,nine,
            equals,add,
            subtract,multiply,divide,
            zero,decimal,cancel;

    public TextView textView;
    public Calc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calc=new Calc();
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);

        zero= (Button)findViewById(R.id.zero);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);

        add=(Button)findViewById(R.id.add);
        subtract=(Button)findViewById(R.id.subtract);
        multiply=(Button)findViewById(R.id.multiply);
        divide=(Button)findViewById(R.id.divide);
        equals=(Button)findViewById(R.id.equals);
        decimal=(Button)findViewById(R.id.decimal);
        cancel=(Button)findViewById(R.id.cancel);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        decimal.setOnClickListener(this);
        cancel.setOnClickListener(this);

}

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.one:

                textView.append("1");
                break;
            case R.id.two:

                textView.append("2");
                break;
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.equals:
                //textView.append("=");
                //no  ..solve
                String math=textView.getText().toString();
                textView.setText(calc.solve(math));
                break;
            case R.id.subtract:
                if (appendSign('-'))textView.append("-");
                break;
            case R.id.add:
                if (appendSign('+'))textView.append("+");
                break;
            case R.id.multiply:
                if (appendSign('X'))textView.append("X");
                break;
            case R.id.divide:
                if (appendSign('/'))textView.append("/");
                break;
            case R.id.decimal:
                if (appendSign('.'))textView.append(".");
                break;
            case R.id.cancel:
                String textViewText=textView.getText().toString();
                int textViewTextLength=textViewText.length();

                if (textViewText.length()>0){
                    textView.setText(textViewText.substring(0,textViewTextLength-1));
                }
                break;

        }


    }

    /**
     * Returns true if character is the last character in the textview text
     * @param character
     * @return boolean
     */

    public boolean appendSign(Character character){
        String text=textView.getText().toString();
        Character lastChar;
        if (text.length()>0){
            lastChar=text.charAt(text.length()-1);
            if (lastChar==character){
                return false;
            }
            if (character=='/' && lastChar=='X'){
                return false;
            }
            if (character=='X' && lastChar=='/'){
                return false;
            }

        }
        return true;

    }


}
