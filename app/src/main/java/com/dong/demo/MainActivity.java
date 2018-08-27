package com.dong.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dong.marqueelib.MarqueeTextviewNofocus;

public class MainActivity extends AppCompatActivity {

    private FlowLikeView mLikeViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnClick = findViewById(R.id.btn_click);

        // 点击飘心控件，和跑马灯无关
        mLikeViewLayout = findViewById(R.id.flowLikeView);

        MarqueeTextviewNofocus marqueeTextviewNofocus = findViewById(R.id.tv_marquee);
        marqueeTextviewNofocus.setText("大家好啊，我是跑马灯~");
        // 初始化
        marqueeTextviewNofocus.init(getWindowManager());
        // 设置滚动方向
        marqueeTextviewNofocus.setScrollDirection(MarqueeTextviewNofocus.RIGHT_TO_LEFT);
        // 设置滚动速度
        marqueeTextviewNofocus.setScrollMode(MarqueeTextviewNofocus.SCROLL_FAST);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLikeViewLayout.addLikeView();
                Toast.makeText(MainActivity.this, "我不要焦点~", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
