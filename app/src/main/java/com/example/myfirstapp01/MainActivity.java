package com.example.myfirstapp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 通知を作成するビルダーの生成
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,
                        "MyChannel_Id");

                // 通知のアイコン
                builder.setSmallIcon(android.R.drawable.ic_dialog_info);

                // 通知のタイトル
                builder.setContentTitle("通知タイトル");

                // 通知の内容
                builder.setContentText("通知の内容");

                // 通知をタップした際にアクティビティを起動する
                // ---
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                intent.putExtra("DATA","通知から起動されました。");

                PendingIntent pen = PendingIntent.getActivity(MainActivity.this,
                        0, // 0は識別子。何でも良い
                        intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);  // オブジェクトを再生成
                builder.setContentIntent(pen);
                builder.setAutoCancel(true);
                // --- ここを削除すると通知の表示のみとなる

                // 通知の作成
                Notification notification = builder.build();

                // 通知サービスで通知を実行する
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, notification); // 0は識別子。何でも良い
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // サブ画面を表示する
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });


    }

    //intentのところ
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Sub.class);
      //  EditText editText = (EditText) findViewById(R.id.editText);
       // String message = editText.getText().toString();
      //  intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
