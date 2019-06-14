package com.example.myfirstapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Sub extends AppCompatActivity {
    private Timer timer;//タイマー用
    private SharedPreferences datastore;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setViews();//add
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.textView);
        textView1.setText(message);
    }

    private void setViews() {
    //    TextView textView2 = findViewById(R.id.textView);
        Button button = findViewById(R.id.button3);//ボタンの設定
        button.setOnClickListener(onClick_button);
      //  Button retun=findViewById(R.id.button);//returnボタンの設定
      //  retun.setOnClickListener(return_button);
    }



    private View.OnClickListener onClick_button=new View.OnClickListener() {
        @Override

        public void onClick(View view) {
            EditText editText = (EditText) findViewById(R.id.editText);//入力値
            SharedPreferences preferences = getSharedPreferences("storedata", MODE_PRIVATE);
            //データ保存


            int a = preferences.getInt("count", 0);
            int b = Integer.parseInt(editText.getText().toString());
            final int c[]= {a + b };//ストック数
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("count", c[0]);//保存先にデータ追加
            editor.commit();

            Timer timer;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    c[0] = c[0] - 2;
                    TextView textView1 = (TextView) findViewById(R.id.textView);
                    textView1.setText(String.valueOf(c[0]));
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 10000);



        }


    };

}
