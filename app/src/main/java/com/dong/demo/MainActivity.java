package com.dong.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dong.marqueelib.MarqueeTextviewNofocus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnClick = findViewById(R.id.btn_click);
        MarqueeTextviewNofocus marqueeTextviewNofocus = findViewById(R.id.tv_marquee);
        marqueeTextviewNofocus.init(getWindowManager());
        marqueeTextviewNofocus.setScrollMode(MarqueeTextviewNofocus.SCROLL_NORM);
        marqueeTextviewNofocus.setScrollDirection(MarqueeTextviewNofocus.RIGHT_TO_LEFT);
        marqueeTextviewNofocus.setText("大家好啊，我是跑马灯~");
        marqueeTextviewNofocus.setTextColor(getResources().getColor(R.color.colorAccent));
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击按钮，获取焦点~", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
