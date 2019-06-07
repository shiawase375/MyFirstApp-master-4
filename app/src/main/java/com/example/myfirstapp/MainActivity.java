package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button3);//ボタンの設定


        TextView textView2=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EditText editText=(EditText)findViewById(R.id.editText);
                EditText editText2 = (EditText)findViewById(R.id.editText2);


                int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText2.getText().toString());
                int c = a + b;

                TextView textView1 = (TextView)findViewById(R.id.textView);
                textView1.setText(String.valueOf(c));



            }


        });
    }
}
