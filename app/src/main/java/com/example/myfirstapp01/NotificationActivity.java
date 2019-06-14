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

public class NotificationActivity extends AppCompatActivity {
    private Timer timer;//タイマー用
    private SharedPreferences datastore;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
       setViews() ;

        // わかりやすいようにタイトルを変更する
        setTitle("Stock");

        Intent intent = getIntent();
        String data = intent.getStringExtra("DATA");

        TextView tv = findViewById(R.id.textView);

        // 通知から起動された場合
        if(data != null) {
            tv.setText(data);
            // ボタンから起動された場合
        }else{
            tv.setText("ボタンから起動しました。");
        }
    }

    private void setViews() {
        TextView textView2 = findViewById(R.id.textView);
        Button button = findViewById(R.id.button10);//ボタンの設定
        button.setOnClickListener(onClick_button);
     //   Button retun=findViewById(R.id.button);//returnボタンの設定
        Button retun=findViewById(R.id.button15);//returnボタンの設定
        retun.setOnClickListener(return_button);

    }



    // final SharedPreferences[] datastore = new SharedPreferences[1];//データ保存先
    //   Timer timer=new Timer();



    private View.OnClickListener onClick_button=new View.OnClickListener() {
        @Override

        public void onClick(View view) {


            EditText editText = (EditText) findViewById(R.id.editText10);//入力値
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
                    TextView textView1 = (TextView) findViewById(R.id.textView13);
                    textView1.setText(String.valueOf(c[0]));
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 10000);




        }


    };

    private View.OnClickListener return_button=new View.OnClickListener(){
        public void onClick(View view) {
            finish();
        }
    };


}



