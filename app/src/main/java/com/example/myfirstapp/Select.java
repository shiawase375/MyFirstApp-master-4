package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Select extends AppCompatActivity {



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initSpinners();
        }

        public void initSpinners(){
            Spinner spinner=(Spinner)findViewById(R.id.spinner);
            String[] labels = getResources().getStringArray(R.array.item_label);
            ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels);
            spinner.setAdapter(adapter);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        }

        public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener{
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                // Spinner を取得
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムのテキストを取得
                String str = spinner.getSelectedItem().toString();
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(str);


                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
               intent.putExtra("sendText",str.toString());
                startActivity(intent);//遷移先の画面を起動
            }

            // 何も選択されなかった時の動作
            public void onNothingSelected(AdapterView parent) {
            }
        }
    }

