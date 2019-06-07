package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
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
        final SharedPreferences[] datastore = new SharedPreferences[1];


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText=(EditText)findViewById(R.id.editText);//入力値
                SharedPreferences preferences = getSharedPreferences("storedata",MODE_PRIVATE);//データ保存


                int a = preferences.getInt("count" , 0);;
                int b = Integer.parseInt(editText.getText().toString());
                int c = a+b;


//ストック数保存
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("count",c);
                editor.commit();

                TextView textView1 = (TextView)findViewById(R.id.textView);
                textView1.setText(String.valueOf(c));



            }


        });
    }
}
