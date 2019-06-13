package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
     private Timer timer;//タイマー用
    private SharedPreferences datastore;
    private EditText editText;

     // SharedPreferences preferences = getSharedPreferences("storedata", MODE_PRIVATE);
    //   SharedPreferences[] datastore = new SharedPreferences[1];//データ保存先
    //  SharedPreferences.Editor editor = preferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

        Intent intent=this.getIntent();
        String text=intent.getStringExtra("sendText");
        TextView textView=(TextView)this.findViewById(R.id.textView);

        // timer =new Timer();
        // TimerTask timerTask=new MyTimerTask();
        // this.timerTask=new TimerTask();

        // this.timer.schedule(timerTask, 1000,500);

    }

    private void setViews() {
        TextView textView2 = findViewById(R.id.textView);
        Button button = findViewById(R.id.button3);//ボタンの設定
        button.setOnClickListener(onClick_button);
        Button retun=findViewById(R.id.button);//returnボタンの設定
        retun.setOnClickListener(return_button);
    }


    // final SharedPreferences[] datastore = new SharedPreferences[1];//データ保存先
    //   Timer timer=new Timer();



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

    private View.OnClickListener return_button=new View.OnClickListener(){
        public void onClick(View view) {
            finish();
        }
        };
    }




